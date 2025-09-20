<template>
  <nav class="navbar">
    <div class="navbar-left">
      <div class="logo-container">
        <router-link to="/" class="nav-linkImg"
          ><img src="@/assets/logo-white.png" alt="Logo" class="logo-img"
        /></router-link>
        <h1 class="navbar-heading">StugLaxen</h1>
      </div>
    </div>

    <div class="navbar-right">
      <router-link to="/" class="nav-link">Hem</router-link>
      <router-link to="/boka" class="nav-link2">Boka Stuga</router-link>
      <router-link to="/admin" class="nav-link3">Admin</router-link>
    </div>
  </nav>
</template>

<script>
export default {};
</script>

<style lang="css" scoped>
@font-face {
  font-family: "Mansalva";
  src: url("../assets/Mansalva-Regular.ttf");
}
h1 {
  font-family: "Mansalva";
  font-size: 45px;
}
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
  background-color: #2f84ff;
  color: white;
}
navbar-left {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}
.navbar-left router-link {
  text-decoration: none;
  color: white;
}

.logo-container {
  display: flex;
  align-items: center;
}
.logo-img {
  width: 110px;
  height: 110px;
  margin-right: 50px;
}

.navbar-heading {
  margin: 0;
}

.navbar-right {
  display: flex;
  align-items: center;
}

.navbar-right router-link {
  text-decoration: none;
  color: white;
  margin-left: 180px;
}

.nav-linkImg {
  font-family: "Mansalva";
  font-size: 25px;
  text-decoration: none;
  color: white;
  margin-left: 10px;
  margin-right: 10px;
}
.nav-link {
  font-family: "Mansalva";
  font-size: 25px;
  text-decoration: none;
  color: white;
  margin-left: 10px;
  margin-right: 40px;
}
.nav-link2 {
  font-family: "Mansalva";
  font-size: 25px;
  text-decoration: none;
  color: white;
  margin-left: 10px;
  margin-right: 40px;
}
.nav-link3 {
  font-family: "Mansalva";
  font-size: 25px;
  text-decoration: none;
  color: white;
  margin-left: 10px;
  margin-right: 100px;
}
</style>
