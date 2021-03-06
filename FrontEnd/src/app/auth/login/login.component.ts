import { Component, OnInit, Inject } from "@angular/core";
import { Router} from "@angular/router";
import { AuthService } from "../../services/auth.service"
import { getDeepFromObject } from "@nebular/auth";
import { NB_AUTH_OPTIONS, NbAuthSocialLink } from "@nebular/auth";
import { NbToastrService } from "@nebular/theme";
import { HttpUserService } from "../../services/http-user.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  redirectDelay: number = 0;

  errors: string[] = [];
  messages: string[] = [];
  user: any = { rememberMe: true };

  showMessages: any = {};
  submitted: boolean = false;

  validation = {};

  constructor(
    private loginservice: AuthService,
    private userService: HttpUserService,
    @Inject(NB_AUTH_OPTIONS) protected config = {},
    protected router: Router,
    private toast: NbToastrService
  ) {
    this.redirectDelay = this.getConfigValue("forms.login.redirectDelay");
    this.showMessages = this.getConfigValue("forms.login.showMessages");

    this.validation = this.getConfigValue("forms.validation");
  }

  loginEmail() {
    this.errors = this.messages = [];
    this.submitted = false;
    console.log(this.user.username+" :"+this.user.password);
    this.loginservice.authenticate(this.user.username,this.user.password).subscribe(
      data => {
        this.submitted = true;
        this.messages.push(
          "Welcome " +
          this.user.username +
            ", you have successfully logged in"
            
        );
        this.showToast();
        this.redirectToDashboard();
       
    }, err => {
      if(err.status == 403 || err.status == 401 || err.status == 500){
        this.errors.push("Authentification failed! Please check your credentials and try again")
      }
      else{
        this.errors.push("Error occured! Please try again later")
        console.log(err)
      }
      this.showToast();
    })
  }

  redirectToDashboard() {
    this.userService.getUtilisateurByLogin(this.user.username).subscribe(data => {
      console.log(data);
      if(data.roles[0].name === "ADMIN"){
        setTimeout(() => {
          this.router.navigate(['/adminPages'])
        }, this.redirectDelay);
      }else if(data.roles[0].name === "USER"){
        setTimeout(() => {
          this.router.navigate(['/pages'])
        }, this.redirectDelay);
      }
    })
    
  }

  getConfigValue(key: string): any {
    return getDeepFromObject(this.config, key, null);
  }

  showToast() {
    if (this.errors && this.errors.length > 0 && !this.submitted) {
      var err = this.errors[0];
      this.toast.warning(err, "Error", { duration: 5000 });
    }
    if (this.messages && this.messages.length > 0 && this.submitted) {
      var msg = this.messages[0];
      this.toast.success(msg, "Success", { duration: 5000 });
    }
  }
  private loadSripts(scriptName: string) {
    var doc = document
      .getElementsByTagName("body")[0]
      .getElementsByTagName("script");

    for (var i = 0; i < doc.length; i++) {
      if (doc[i].getAttribute("src").includes(scriptName)) {
        document.getElementsByTagName("body")[0].removeChild(doc[i]);
        continue;
      }
    }
    if (i >= doc.length) {
      const node = document.createElement("script");
      node.src = "/assets/" + scriptName + ".js";
      node.type = "text/javascript";
      node.async = false;
      node.charset = "utf-8";
      document.getElementsByTagName("body")[0].appendChild(node);
    }
  }

  ngOnInit() {

    this.loadSripts("test");
  }
}


