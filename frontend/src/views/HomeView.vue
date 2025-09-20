<template>
  <div class="home">
    <div class="card">
      <h2>Välkommen till</h2>
      <div class="img-logo">
        <img src="../assets/logo-black.png" alt="logo" />
      </div>
      <button class="btn-stor" @click="$router.push('/boka')">
        Boka stuga
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  components: {},
};
</script>

<style>
@font-face {
  font-family: "Mansalva";
  src: url("../assets/Mansalva-Regular.ttf");
}
.home {
  background: #dedbd3;
  height: 100%;
  width: 100%;
}
.img-logo img {
  width: 650px; /* set desired width */
  height: auto; /* keep aspect ratio */
  margin-bottom: 50px;
}
h2 {
  font-family: "Mansalva";
  font-size: 50px;
}
.btn-stor {
  font-family: "Mansalva";
  font-weight: 0;
  font-size: 24px;
  color: #fff;
  background-color: #2f84ff;
  padding: 15px 40px;
  border: 2px solid #2f84ff;
  border-radius: 10px;
  cursor: pointer;
  transition: background-color 0.5s, color 0.5s;
  margin-left: 20px;
}

.btn-stor:hover {
  background-color: #fff;
  color: #2f84ff;
}
</style>
