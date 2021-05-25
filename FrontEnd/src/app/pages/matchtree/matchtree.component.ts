import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'ngx-matchtree',
  templateUrl: './matchtree.component.html',
  styleUrls: ['./matchtree.component.scss']
})
export class MatchtreeComponent implements OnInit {

  @Input() match: any;

  constructor() {
  }

  ngOnInit() {
  }
}
