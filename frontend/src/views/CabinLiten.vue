<template>
  <div>
    <div class="header">
      <div class="header-content">
        <div class="arrow-button" @click="$router.push('/boka')">
          <div class="arrow-left"></div>
          <p class="back">Tillbaka</p>
        </div>
        <h1>Små stugor</h1>
      </div>
    </div>
    <div v-for="cabin in cabins" :key="cabin.id" class="cabinOffers">
      <h3>{{ cabin.name }}</h3>
      <div class="cabin-info">
        <img class="cabin-img" :src="getCabinImageSrc(cabin.id)" alt="cabin" />
        <p>{{ cabin.details }}</p>
        <p>Pris: {{ cabin.price }}/dyng</p>
        <p class="booked">{{ checkBookings(cabin.booked) }}</p>
        <button
          class="btn-boka"
          @click="bookCabin(cabin.id)"
          v-show="!cabin.booked"
        >
          Boka
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      cabins: [],
    };
  },
  mounted() {
    fetch("http://localhost:8081/api/v1/cabinstype/Liten")
      .then((res) => res.json())
      .then((data) => (this.cabins = data))
      .catch((err) => console.log(err.message));
  },
  methods: {
    checkBookings(booked) {
      if (booked) {
        return "Bokad";
      } else {
        return "Ledigt";
      }
    },
    getCabinImageSrc(cabinId) {
      return require(`../assets/cabins/${cabinId}.jpg`);
    },
    bookCabin(index) {
      console.log(index);
      window.localStorage.setItem("cabinId", index);
      this.$router.push({ name: "bookning" });
    },
  },
};
</script>

<style lang="css" scoped>
@font-face {
  font-family: "Mansalva";
  src: url("../assets/Mansalva-Regular.ttf");
}
@font-face {
  font-family: "Sriracha";
  src: url("../assets/Sriracha Regular.ttf");
}

h1,
.cabinOffers {
  font-family: "Mansalva";
}
h1 {
  font-size: 50px;
}
h3 {
  font-size: 30px;
}

p {
  font-family: "Sriracha";
  font-size: 20px;
}

.cabinOffers {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-color: #f4f3f0;
  width: 40%;
  margin: 20px auto;
  padding: 20px;
  border-radius: 15px;
}

.cabin-img {
  height: 400px;
  width: 500px;
  object-fit: cover;
}

.booked {
  font-size: 35px;
  font-weight: bold;
}

.btn-boka {
  font-family: "Mansalva";
  font-weight: 0;
  font-size: 18px;
  color: #fff;
  background-color: #2f84ff;
  padding: 10px 30px;
  border: 2px solid #2f84ff;
  box-shadow: 0px 10px 15px -3px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  transition: 1000ms;
  cursor: pointer;
  margin-top: 20px;
}

.btn-boka:hover {
  padding: 10px 40px;
  background-color: #fff;
  color: #2f84ff;
  border: solid 2px #2f84ff;
}

.arrow-button {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 110px;
  height: 60px;
  background-color: #2f84ff;
  color: #fff;
  cursor: pointer;
  border: none;
  border-radius: 5px;
  transition: background-color 0.3s;
}
.back {
  padding: 5px;
}

.arrow-left {
  width: 0;
  height: 0;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-right: 15px solid #fff;
}
.header {
  display: flex;
  justify-content: center;
  align-items: center;
}

.header-content {
  display: flex;
  flex-direction: column-reverse;
  align-items: center;
}
</style>
