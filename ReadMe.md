
<h1 id="arbetsprov-för-digg">Arbetsprov för DIGG</h1>
<p>Det här projektet är en fullstack-applikation som består av en frontend byggd med <strong>Vue.js</strong> och en backend byggd med <strong>Spring Boot</strong>. Projektet är designat för att hantera användarinformation genom att kunna skapa, redigera, radera och visa användare. Det är containeriserat med <strong>Docker</strong>, vilket gör det lättare att köra applikationen utan att manuellt installera alla beroenden på din dator.</p>
<h2 id="innehållsförteckning">Innehållsförteckning</h2>
<ol>
<li><a href="#projektets-struktur">Projektets struktur</a></li>
<li><a href="#teknologier-som-anv%C3%A4nds">Teknologier som används</a></li>
<li><a href="#f%C3%B6ruts%C3%A4ttningar">Förutsättningar</a></li>
<li><a href="#installation-och-k%C3%B6rning">Installation och körning</a>
<ol>
<li><a href="#anv%C3%A4nda-docker">Använda Docker</a></li>
<li><a href="#k%C3%B6ra-frontend-och-backend-lokalt">Köra frontend och backend lokalt</a></li>
</ol>
</li>
<li><a href="#testning">Testning</a></li>
<li><a href="#api-dokumentation">API-dokumentation</a></li>
<li><a href="#vanliga-problem-och-fels%C3%B6kning">Vanliga problem och felsökning</a></li>
<li><a href="#framtida-f%C3%B6rb%C3%A4ttringar">Framtida förbättringar</a></li>
<li><a href="#licens">Licens</a></li>
</ol>
<h2 id="projektets-struktur">Projektets struktur</h2>
<p>Applikationen är uppdelad i två huvuddelar:</p>
<ol>
<li><strong>Frontend</strong> - Användargränssnittet som körs i webbläsaren. Byggt med Vue.js och hanteras av <strong>Nginx</strong> i produktionsmiljö.</li>
<li><strong>Backend</strong> - API och datalogik som hanteras av Spring Boot med Java. Det hanterar alla API-anrop för att skapa, uppdatera, radera och visa användare.</li>
</ol>
<p>Projektets struktur ser ut så här:</p>
<pre><code>digg-arbetsprov/
│
├── frontend/              # Vue.js frontend-kod
│   ├── src/               # Källkod för frontend
│   └── Dockerfile         # Dockerfil för frontend
│
├── backend/               # Spring Boot backend-kod
│   ├── src/               # Källkod för backend
│   └── Dockerfile         # Dockerfil för backend
│
├── docker-compose.yml      # Docker Compose-fil för att köra hela applikationen
├── README.md               # Dokumentationen (den här filen)
└── ...
</code></pre>
<h2 id="teknologier-som-används">Teknologier som används</h2>
<ul>
<li><strong>Vue.js</strong> - Ett JavaScript-ramverk för att bygga användargränssnitt.</li>
<li><strong>Spring Boot</strong> - En Java-baserad ramverk för backend som gör det enkelt att skapa REST API:er.</li>
<li><strong>Docker</strong> - Används för att paketera applikationen i containrar, så att det är enkelt att köra applikationen utan att behöva konfigurera alla verktyg själv.</li>
<li><strong>JUnit</strong> - Används för att skriva och köra enhetstester för backend.</li>
<li><strong>H2 Database</strong> - En in-memory databas som används för utveckling och testning.</li>
<li><strong>Swagger/OpenAPI</strong> - API-dokumentationsverktyg som ger en interaktiv översikt av alla tillgängliga endpoints.</li>
</ul>
<h2 id="förutsättningar">Förutsättningar</h2>
<p>Innan du kan köra det här projektet behöver du ha följande installerat:</p>
<ol>
<li><strong>Docker</strong> - <a href="https://docs.docker.com/get-docker/">Installera Docker</a></li>
<li><strong>Docker Compose</strong> - Följer ofta med när du installerar Docker.</li>
<li>(Valfritt) <strong>Node.js och npm</strong> - <a href="https://nodejs.org/en/">Installera Node.js</a> (om du vill köra frontend utan Docker)</li>
<li>(Valfritt) <strong>Java 17 och Maven</strong> - <a href="https://www.oracle.com/java/technologies/javase-jdk17-downloads.html">Installera Java</a> och <a href="https://maven.apache.org/download.cgi">Maven</a> (om du vill köra backend utan Docker)</li>
</ol>
<h2 id="installation-och-körning">Installation och körning</h2>
<h3 id="använda-docker">Använda Docker</h3>
<h4 id="klona-projektet-från-github">1. Klona projektet från GitHub</h4>
<p>Först måste du klona projektet till din lokala dator. Detta gör du genom att köra följande kommando i en terminal:</p>
<pre class=" language-bash"><code class="prism  language-bash"><span class="token function">git</span> clone https://github.com/ditt-konto/digg-arbetsprov.git
<span class="token function">cd</span> digg-arbetsprov
</code></pre>
<h4 id="bygg-och-starta-applikationen-med-docker-compose">2. Bygg och starta applikationen med Docker Compose</h4>
<p>För att bygga och köra hela applikationen (både frontend och backend) samtidigt, kör detta kommando i projektets rotmapp:</p>
<pre class=" language-bash"><code class="prism  language-bash">docker-compose up --build
</code></pre>
<ul>
<li>Detta kommando kommer att bygga frontend och backend från grunden.</li>
<li>När detta är klart kan du öppna webbläsaren och besöka <a href="http://localhost">http://localhost</a> för att se frontend.</li>
<li>Backend-API:n körs på <a href="http://localhost:8080">http://localhost:8080</a>.</li>
</ul>
<h4 id="kontrollera-att-applikationen-körs">3. Kontrollera att applikationen körs</h4>
<p>När applikationen har startat kan du öppna din webbläsare och gå till:</p>
<ul>
<li><strong>Frontend:</strong> <a href="http://localhost">http://localhost</a></li>
<li><strong>Backend API:</strong> <a href="http://localhost:8080">http://localhost:8080</a></li>
<li><strong>H2 Console:</strong> <a href="http://localhost:8080/h2-console">http://localhost:8080/h2-console</a>
<ul>
<li>JDBC URL: finns i application.properties</li>
<li>Användarnamn: sa</li>
<li>Lösenord: password</li>
</ul>
</li>
<li><strong>Swagger UI:</strong> <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a></li>
</ul>
<h4 id="stoppa-applikationen">Stoppa applikationen</h4>
<p>För att stänga ner applikationen, tryck <code>CTRL + C</code> i terminalen där Docker Compose körs. Du kan också stänga ner alla Docker-containrar med:</p>
<pre class=" language-bash"><code class="prism  language-bash">docker-compose down
</code></pre>
<h3 id="köra-frontend-och-backend-lokalt">Köra frontend och backend lokalt</h3>
<p>Om du föredrar att köra frontend och backend utan Docker kan du göra det med följande steg:</p>
<h4 id="backend">Backend</h4>
<ol>
<li>
<p>Gå till backend-katalogen:</p>
<pre class=" language-bash"><code class="prism  language-bash"><span class="token function">cd</span> backend
</code></pre>
</li>
<li>
<p>Bygg och kör backend med Maven (du måste ha Java och Maven installerat):</p>
<pre class=" language-bash"><code class="prism  language-bash">mvn clean package
java -jar target/backend.jar
</code></pre>
</li>
</ol>
<p>Backend kommer nu att köra på <a href="http://localhost:8080">http://localhost:8080</a>.</p>
<h4 id="frontend">Frontend</h4>
<ol>
<li>
<p>Gå till frontend-katalogen:</p>
<pre class=" language-bash"><code class="prism  language-bash"><span class="token function">cd</span> frontend
</code></pre>
</li>
<li>
<p>Installera beroenden (du måste ha Node.js och npm installerat):</p>
<pre class=" language-bash"><code class="prism  language-bash"><span class="token function">npm</span> <span class="token function">install</span>
</code></pre>
</li>
<li>
<p>Starta utvecklingsservern:</p>
<pre class=" language-bash"><code class="prism  language-bash"><span class="token function">npm</span> run dev
</code></pre>
</li>
</ol>
<p>Frontend kommer nu att köra på <a href="http://localhost:3000">http://localhost:3000</a>.</p>
<h2 id="testning">Testning</h2>
<h3 id="backend-enhetstester">Backend-enhetstester</h3>
<p>Det finns enhetstester för backend som är skrivna med <strong>JUnit</strong>. Dessa tester verifierar att backenden fungerar som förväntat. För att köra testerna, gå till backend-katalogen och kör:</p>
<pre class=" language-bash"><code class="prism  language-bash">mvn <span class="token function">test</span>
</code></pre>
<p>Om alla tester lyckas, kommer du att se meddelandet “BUILD SUCCESS” i terminalen.</p>
<h3 id="enhetstester-som-täcks">Enhetstester som täcks</h3>
<ol>
<li>Hämta alla användare (GET /digg/user)</li>
<li>Skapa ny användare (POST /digg/newuser)</li>
<li>Uppdatera användare (PUT /digg/edituser)</li>
<li>Radera användare (DELETE /digg/deleteuser)</li>
</ol>
<h2 id="api-dokumentation">API-dokumentation</h2>
<p>Backend tillhandahåller ett REST API som gör det möjligt att interagera med användardata. Här är en översikt av de API-slutpunkter som finns:</p>
<ol>
<li><strong>GET /digg/user</strong> - Hämtar alla användare.</li>
<li><strong>POST /digg/newuser</strong> - Skapar en ny användare.</li>
<li><strong>PUT /digg/edituser</strong> - Uppdaterar en befintlig användare.</li>
<li><strong>DELETE /digg/deleteuser</strong> - Raderar en användare.</li>
</ol>
<p>Alla anrop returnerar data i <strong>JSON</strong>-format.</p>
<h2 id="vanliga-problem-och-felsökning">Vanliga problem och felsökning</h2>
<h3 id="problem-port-already-in-use">Problem: “Port already in use”</h3>
<p>Om du får ett felmeddelande om att en port redan används, kan det bero på att en annan applikation använder port 80 eller 8080. För att lösa detta kan du:</p>
<ol>
<li>Stänga den andra applikationen som använder porten.</li>
<li>Ändra porten i <code>docker-compose.yml</code>-filen eller i dina Docker-filer.</li>
</ol>
<h3 id="problem-connection-refused-när-man-försöker-nå-backend">Problem: “Connection refused” när man försöker nå backend</h3>
<p>Detta kan bero på att backend inte har startat korrekt. Kontrollera backend-loggarna i terminalen där du kör Docker eller Maven för eventuella felmeddelanden.</p>
<h2 id="framtida-förbättringar">Framtida förbättringar</h2>
<ul>
<li>Implementera fler valideringar både på klient- och serversidan.</li>
<li>Lägg till fler enhetstester, inklusive integrationstester.</li>
<li>Skapa en CI/CD-pipeline för automatiserade tester och distribution.</li>
</ul>
<h2 id="licens">Licens</h2>
<p>Det här projektet har ingen specifik licens i nuläget, men du kan använda det för utbildningssyfte eller som referens.</p>

