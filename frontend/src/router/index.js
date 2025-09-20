import { createRouter, createWebHashHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },

  {
    path: "/boka/stor",
    name: "Stor",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/CabinStor.vue"),
  },
  {
    path: "/boka/mellan",
    name: "Mellan",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/CabinMellan.vue"),
  },
  {
    path: "/boka/liten",
    name: "Liten",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/CabinLiten.vue"),
  },
  {
    path: "/boka/bokning",
    name: "bookning",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/BookingView.vue"),
  },

  {
    path: "/boka",
    name: "boka",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/BokaView.vue"),
  },
  {
    path: "/admin",
    name: "admin",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AdminView.vue"),
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
