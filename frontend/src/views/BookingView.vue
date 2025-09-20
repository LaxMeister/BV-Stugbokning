<template>
  <div>
    <h2>Vill du boka denna?</h2>
    <h3>{{ this.cabin.name }}</h3>
    <div class="cabin-info">
      <img class="cabin-img" :src="getCabinImageSrc(cabin.id)" alt="cabin" />
      <p>{{ cabin.details }}</p>
      <p>Pris: {{ cabin.price }}/dyng</p>
      <p class="booked">{{ checkBookings(cabin.booked) }}</p>
      <div class="dateInputs">
        <div class="input-group">
          <label for="fromDate">Från:</label>
          <input type="date" name="fromDate" id="fromDate" v-model="fromDate" />
        </div>
        <div class="input-group">
          <label for="returnDate">Till:</label>
          <input
            type="date"
            name="returnDate"
            id="returnDate"
            v-model="retrunDate"
          />
        </div>
      </div>
      <div class="input-group">
        <label for="email">Skriv din e-post för att boka:</label>
        <input type="email" name="email" id="email" v-model="email" />
      </div>
      <button class="btn-boka" @click="sendBooking" v-show="!cabin.booked">
        Boka
      </button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      cabin: {},
      cabinID: "",
      retrunDate: "",
      fromDate: "",
      email: "",
    };
  },
  async created() {
    this.cabinID = window.localStorage.getItem("cabinId");
    await fetch("http://localhost:8081/api/v1/cabin/" + this.cabinID)
      .then((res) => res.json())
      .then((data) => (this.cabin = data))
      .catch((err) => console.log(err.message));
  },
  methods: {
    checkProps() {
      console.log(this.retrunDate);
    },
    getCabinImageSrc(cabinId) {
      if (cabinId) {
        return require(`../assets/cabins/${cabinId}.jpg`);
      } else {
        return "";
      }
    },
    checkBookings(booked) {
      if (booked) {
        return "Bokad";
      } else {
        return "Ledigt";
      }
    },

    async sendBooking() {
      const date = this.fromDate + this.retrunDate;

      try {
        const response = await fetch(
          "http://localhost:8081/api/v1/ordercabin/1" + this.cabinID,
          {
            method: "POST",
            headers: {
              "Content-Type": "text/plain",
            },
            body: date,
          }
        );

        if (!response.ok) {
          throw new Error("Network response was not ok");
        }

        const data = await response.json();

        console.log(data);
      } catch (error) {
        console.error("Error:", error.message);
      }
      await this.emailSend();
      window.alert(
        "Du har bokat stugan.\n Bokningsbekräftelse skickad till eposten du angav."
      );
      this.$router.push("/boka/");
    },

    async emailSend() {
      const config = {
        to: this.email,
        subject: "Stugbokning",
        text: `Hej!\r\n\r\nDu har bokat ${this.cabin.name} hoppas du får en trevlig vistelse!`,
      };
      try {
        const response = await fetch(
          "http://localhost:8081/api/v1/send-email",
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(config),
          }
        );

        if (!response.ok) {
          throw new Error("Network response was not ok");
        }

        const data = await response.json();

        console.log(data);
      } catch (error) {
        console.error("Error:", error.message);
      }
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

.cabinOffers {
  font-family: "Mansalva";
}
h1 {
  font-size: 50px;
}
h3 {
  font-family: "Mansalva";
  font-size: 30px;
}

p {
  font-family: "Sriracha";
  font-size: 20px;
}
.cabin-info {
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

.cabin-img {
  height: 400px;
  width: 500px;
  object-fit: cover;
}
.dateInputs {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
}

.input-group {
  display: flex;
  flex-direction: column;
  margin-right: 15px;
  font-family: "Sriracha";
}

.input-group label {
  margin-bottom: 5px;
}
</style>
