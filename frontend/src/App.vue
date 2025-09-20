<template>
  <Navbar />
  <RouterView />
</template>

<script>
// @ is an alias to /src
import Navbar from "@/components/Nav-bar.vue";
import { RouterView } from "vue-router";

export default {
  components: {
    Navbar,
    RouterView,
  },
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #dedbd3;
  background: #dedbd3;
  min-height: 100vh;
  overflow-y: hidden;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
