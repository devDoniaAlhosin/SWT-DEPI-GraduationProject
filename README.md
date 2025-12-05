<h1>🛒 SWT-DEPI-GraduationProject – OpenCart Automation Framework</h1>

<p>
This repository contains a complete <strong>Selenium Automation Framework</strong> built for testing the
<strong>OpenCart Demo Website</strong>.<br>
The project focuses on <strong>end-to-end automation of user-side functionalities</strong> using
Selenium WebDriver, Java, TestNG, and the Page Object Model (POM).
</p>

<hr>

<h2>🚀 Project Overview</h2>

<p>This framework automates the main workflows of the OpenCart platform and includes:</p>

<ul>
  <li>Functional automated test scripts</li>
  <li>End-to-end test flows</li>
  <li>Scalable Page Object Model (POM)</li>
  <li>HTML reporting with Extent Reports</li>
  <li>Modular Git branch structure</li>
  <li>Clean, maintainable Selenium test design</li>
</ul>

<hr>

<h2>🎯 Automated Modules</h2>

<ul>
  <li>🔐 Registration (valid &amp; invalid scenarios)</li>
  <li>🔑 Login / Logout / Forgot Password</li>
  <li>🔎 Product Search &amp; Filters</li>
  <li>📄 Product Details Page</li>
  <li>❤️ Wishlist Management</li>
  <li>🛒 Cart operations (Add / Remove / Update Quantity)</li>
  <li>💳 Checkout (Guest &amp; Registered users)</li>
  <li>📜 Order History Validation</li>
</ul>

<hr>

<h2>👥 Automation Team Members</h2>

<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Automation Responsibility</th>
      <th>Contact 📧</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Rawan Mohammed</strong></td>
      <td>Checkout &amp; Order History</td>
      <td>rawanmohammed99@gmail.com</td>
    </tr>
    <tr>
      <td><strong>Yasmin Ali Helmy</strong></td>
      <td>Search &amp; Filters</td>
      <td>Yasmin.ali.helmy@gmail.com</td>
    </tr>
    <tr>
      <td><strong>Shaimaa Mansour</strong></td>
      <td>Product Page &amp; Wishlist</td>
      <td>shaimaamansour413@gmail.com</td>
    </tr>
    <tr>
      <td><strong>Heba Srour</strong></td>
      <td>Registration</td>
      <td>hebasrour1988@gmail.com</td>
    </tr>
    <tr>
      <td><strong>Donia El Hussien</strong></td>
      <td>Login / Logout / Forgot Password</td>
      <td>doniaelhussien@gmail.com</td>
    </tr>
    <tr>
      <td><strong>Bassant Adel</strong></td>
      <td>Cart &amp; Mini Cart</td>
      <td>basantadel99@gmail.com</td>
    </tr>
  </tbody>
</table>

<hr>

<h2>🛠️ Tech Stack</h2>

<ul>
  <li><strong>Java</strong></li>
  <li><strong>Selenium WebDriver</strong></li>
  <li><strong>TestNG</strong></li>
  <li><strong>Maven</strong></li>
  <li><strong>Extent Reports</strong> (HTML Reporting)</li>
  <li><strong>Git / GitHub</strong></li>
</ul>

<hr>

<h2>📁 Framework Structure</h2>

<pre><code>SWT-DEPI-GraduationProject/
│
├── src/
│   ├── test/java/
│   │   ├── tests/
│   │   ├── pages/     ← Page Object Model classes
│   │   ├── utils/     ← BrowserFactory, ConfigReader, helpers...
│   │   ├── base/      ← BaseTest.java
│   │
│   ├── main/resources/
│       ├── config.properties
│       └── testdata.json
│
├── pom.xml
├── testng.xml
└── README.md
</code></pre>

<hr>

<h2>🧪 Framework Features</h2>

<ul>
  <li>Clean <strong>Page Object Model (POM)</strong> structure</li>
  <li>Centralized WebDriver setup via <code>BaseTest</code></li>
  <li>Automatic driver management using <strong>WebDriverManager</strong></li>
  <li>JSON-based test data handling</li>
  <li>HTML reporting with <strong>Extent Reports</strong></li>
  <li>Reusable utilities and helper classes</li>
  <li>Error handling with automatic screenshot capture</li>
</ul>

<hr>

<h2>🔀 Git Branch Workflow</h2>

<p>The automation work is organized into feature branches:</p>

<pre><code>main                     ← protected
feature/registration
feature/login-logout-forgetpassword
feature/search-filters
feature/product-wishlist
feature/cart-minicart
feature/checkout-orderhistory
</code></pre>

<p>
Each team member commits to their own feature branch, then opens a Pull Request (PR) to merge changes into
<strong>main</strong>.
</p>

<hr>

<h1>🛠 Installation &amp; Setup – Run Selenium Tests Locally</h1>

<p>
To run the OpenCart automation test suite, you need to install <strong>OpenCart locally</strong> and configure
the framework to point to your local environment. Follow the steps below.
</p>

<h2>1️⃣ Install OpenCart Locally (Using XAMPP)</h2>

<p><strong>Recommended: XAMPP-based setup</strong></p>

<ul>
  <li>
    Download XAMPP:<br>
    <a href="https://www.apachefriends.org/download.html" target="_blank" rel="noreferrer">
      https://www.apachefriends.org/download.html
    </a>
  </li>
  <li>Start the following services:
    <ul>
      <li>Apache</li>
      <li>MySQL</li>
    </ul>
  </li>

  <li>
    Download OpenCart:<br>
    <a href="https://www.opencart.com/index.php?route=cms/download" target="_blank" rel="noreferrer">
      https://www.opencart.com/index.php?route=cms/download
    </a>
  </li>

  <li>
    Extract OpenCart to:<br>
    <strong>C:/xampp/htdocs/opencartproject/</strong>
  </li>

  <li>Create a database:
    <ul>
      <li>Open phpMyAdmin → <code>http://localhost/phpmyadmin</code></li>
      <li>Create a database named: <strong>opencart</strong></li>
    </ul>
  </li>

  <li>Run the OpenCart installer:
    <ul>
      <li>Navigate to:<br><code>http://localhost/opencartproject/upload/</code></li>
      <li>Database settings:
        <ul>
          <li>Host: <code>localhost</code></li>
          <li>Username: <code>root</code></li>
          <li>Password: <em>(leave empty)</em></li>
          <li>Database: <code>opencart</code></li>
        </ul>
      </li>
      <li>Admin account:
        <ul>
          <li>Email: <code>admin@example.com</code></li>
          <li>Password: <code>admin123</code></li>
        </ul>
      </li>
    </ul>
  </li>

  <li>After installation:
    <ul>
      <li>Delete the <strong>/upload</strong> folder</li>
      <li>Move the remaining files one level up into <strong>/opencartproject</strong></li>
    </ul>
  </li>
</ul>

<h2>2️⃣ Configure the Automation Framework</h2>

<p>Edit the configuration file:</p>

<p><code>src/main/resources/config.properties</code></p>

<p>Set the following properties:</p>

<pre><code>app.base.url = http://localhost/opencartproject/
browser = chrome
</code></pre>

<h2>3️⃣ Update Test Data (Optional)</h2>

<p>Test data is stored in:</p>

<p><code>src/main/resources/testdata.json</code></p>

<p>You can update:</p>

<ul>
  <li>Login credentials</li>
  <li>Guest checkout data</li>
  <li>Registration data</li>
</ul>

<p>Example snippet:</p>

<pre><code>"login.valid.email": "admin@example.com",
"login.valid.password": "admin123",

"checkout.guest.firstname": "John",
"checkout.guest.lastname": "Doe",
"checkout.guest.email": "guest@test.com",
"checkout.guest.telephone": "0123456789",
"checkout.guest.address1": "Street 1",
"checkout.guest.city": "Cairo",
"checkout.guest.postcode": "12345",
"checkout.guest.country": "Egypt",
"checkout.guest.region": "Aswan"
</code></pre>

<h2>4️⃣ Run the Automation Tests</h2>

<ul>
  <li>
    <strong>Run via IntelliJ / Eclipse:</strong><br>
    Right-click <strong>testng.xml</strong> → <em>Run</em>
  </li>
  <li>
    <strong>Run entire test suite with Maven:</strong><br>
    <code>mvn clean test</code>
  </li>
  <li>
    <strong>Run a specific test class:</strong><br>
    <code>mvn -Dtest=LoginTests test</code>
  </li>
</ul>

<h2>5️⃣ View Test Execution Reports</h2>

<ul>
  <li>Reports are generated in:<br>
    <code>/test-output/ExtentReports/</code>
  </li>
  <li>Open the HTML report:<br>
    <code>index.html</code>
  </li>
</ul>

<h2>6️⃣ Required Tools</h2>

<ul>
  <li>Java 17 or later</li>
  <li>Maven 3+</li>
  <li>IntelliJ IDEA or Eclipse</li>
  <li>Google Chrome</li>
  <li>ChromeDriver (managed automatically via WebDriverManager)</li>
</ul>

<h2>7️⃣ Auto-Register Function (Optional)</h2>

<ul>
  <li>If login fails because the user does not exist, the framework auto-registers a new user.</li>
  <li>The generated email is stored in: <code>GlobalData.LAST_REGISTERED_EMAIL</code></li>
  <li>The framework then attempts login again automatically.</li>
</ul>

<hr>

<h2>📌 Summary</h2>

<p>
This project demonstrates a complete, production-style <strong>Selenium automation framework</strong> for the
OpenCart platform.<br>
It showcases best practices in QA automation, clean architecture, modular design, and a collaborative
Git-based workflow — making it suitable as a strong portfolio project for professional QA and test automation roles.
</p>
