<template>
  <div class="table-container">
    <h1>Administratörsläge</h1>
    <table>
      <thead>
        <tr>
          <th>Namn</th>
          <th>Typ</th>
          <th>Pris</th>
          <th>Tillgänglig</th>
          <th>Beskrivning</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in data" :key="item.name">
          <td>{{ item.name }}</td>
          <td>{{ item.type }}</td>
          <td>{{ item.price }}</td>
          <td>{{ item.booked ? "Nej" : "Ja" }}</td>
          <td>{{ item.details }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      data: [],
    };
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    async fetchData() {
      fetch("http://localhost:8081/api/v1/cabins")
        .then((res) => res.json())
        .then((data) => (this.data = data))
        .catch((err) => console.log(err.message));
    },
  },
};
</script>

<style scoped>
@font-face {
  font-family: "Sriracha";
  src: url("../assets/Sriracha Regular.ttf");
}
.table-container {
  margin: 0 auto; /* Center the container horizontally */
  max-width: 800px; /* Set a maximum width for the container */
  text-align: center;
  font-family: "Sriracha";
}

table {
  width: 100%; /* Make the table fill the container */
  border-collapse: collapse;
  margin-top: 20px; /* Add some top margin for spacing */
}

thead {
  background-color: #2f84ff; /* Light gray background for the header */
  color: #ddd;
}

th,
td {
  padding: 12px;
  text-align: left;
  border-bottom: 1px solid #f4f3f0; /* Add a border between rows */
}

tr:hover {
  background-color: #2f84ff;
  color: #f4f3f0; /* Light gray background on hover */
}
</style>
