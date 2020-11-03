// @ts-nocheck
import { ApplyPluginsType } from 'C:/code/coding/haozufang/itcast-reactjs/node_modules/@umijs/runtime';
import { plugin } from './plugin';

export function getRoutes() {
  const routes = [
  {
    "path": "/",
    "component": require('C:/code/coding/haozufang/itcast-reactjs/src/layouts').default,
    "routes": [
      {
        "path": "/MyTabs",
        "component": require('C:/code/coding/haozufang/itcast-reactjs/src/pages/MyTabs').default,
        "exact": true
      },
      {
        "path": "/user",
        "routes": [
          {
            "path": "/user/list",
            "component": require('C:/code/coding/haozufang/itcast-reactjs/src/pages/user/UserList').default,
            "exact": true
          },
          {
            "path": "/user/add",
            "component": require('C:/code/coding/haozufang/itcast-reactjs/src/pages/user/UserAdd').default,
            "exact": true
          }
        ]
      }
    ]
  }
];

  // allow user to extend routes
  plugin.applyPlugins({
    key: 'patchRoutes',
    type: ApplyPluginsType.event,
    args: { routes },
  });

  return routes;
}
