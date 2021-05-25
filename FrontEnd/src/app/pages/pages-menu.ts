import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Equipes',
    icon: 'people-outline',
    link: '/pages/equipes'
  },
  {
    title: 'Matches',
    icon: 'shield-outline',
    children: [
      {
        title: 'Group Phase',
        link: '/pages/groupPhase',
      },
      {
        title: 'Knockout Phase',
        link: '/pages/layout/stepper',
      },
    ],
  },
  {
    title: 'Groups',
    icon: 'grid-outline',
    link: '/pages/ui-features',
    children: [
      {
        title: 'Group A',
        link: '/pages/ui-features/grid',
      },
      {
        title: 'Group B',
        link: '/pages/ui-features/icons',
      },
      {
        title: 'Group C',
        link: '/pages/ui-features/typography',
      },
      {
        title: 'Group D',
        link: '/pages/ui-features/search-fields',
      },
      {
        title: 'Group E',
        link: '/pages/ui-features/search-fields',
      },
      {
        title: 'Group F',
        link: '/pages/ui-features/search-fields',
      },
      {
        title: 'Group G',
        link: '/pages/ui-features/search-fields',
      },
      {
        title: 'Group H',
        link: '/pages/ui-features/search-fields',
      },
    ],
  },
];
