<template>
  <div class="about">
    <h3 class="cabin-size">Kul att du vill boka en stuga!</h3>
    <h3 class="cabin-size">
      Här kan du välja den storlek på stugan som passar dig bäst.
    </h3>
    <!-- <h3 class="cabin-size">Storlek på stuga</h3> -->
    <div class="button-row">
      <button class="btn-stor" @click="$router.push('/boka/stor')">Stor</button>
      <button class="btn-mellan" @click="$router.push('/boka/mellan')">
        Mellan
      </button>
      <button class="btn-liten" @click="$router.push('/boka/liten')">
        Liten
      </button>
    </div>

    <div v-show="isStor" class="stor">
      <h3 class="stor-title">Stora Sugor</h3>
    </div>
    <div v-show="isMellan" class="stor">
      <h3 class="stor-title">Mellan Sugor</h3>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isStor: false,
      isMellan: false,
      isLiten: false,
      cabinType: "Stor",
      cabinsStor: {},
      cabinsMellan: {},
      cabinsLiten: {},
    };
  },
};
</script>

<style lang="css" scoped>
@font-face {
  font-family: "Mansalva";
  src: url("../assets/Mansalva-Regular.ttf");
}
html {
  overflow-y: hidden;
}
.about {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  overflow-y: hidden;
}

.cabin-size {
  font-family: "Mansalva";
  font-size: 30px;
  margin-bottom: 20px;
}

.button-row {
  display: flex;
  justify-content: space-around;
  margin-bottom: 20px;
}

.btn-stor,
.btn-mellan,
.btn-liten {
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

.btn-stor:hover,
.btn-mellan:hover,
.btn-liten:hover {
  background-color: #fff;
  color: #2f84ff;
}
</style>
