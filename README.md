<h1>🛒 SWT-DEPI-GraduationProject – OpenCart Automation Framework</h1>

<p>
This repository contains a complete <strong>Selenium Automation Framework</strong> for 
testing the <strong>OpenCart Demo Website</strong>.  
The project focuses fully on <strong>automating user-side functionalities</strong> using 
Selenium WebDriver, TestNG, Java, and the Page Object Model (POM).
</p>

<hr>

<h2>🚀 Project Overview</h2>
<p>
This automation framework covers the end-to-end workflows of OpenCart.  
It includes:
</p>

<ul>
    <li>Automated functional test scripts</li>
    <li>End-to-end test flows</li>
    <li>Reusable Page Object Model (POM)</li>
    <li>HTML reporting using Extent Reports</li>
    <li>Modular branch structure with Git</li>
    <li>Well-structured Selenium test design</li>
</ul>

<hr>

<h2>🎯 Automated Modules – What We Covered</h2>

<ul>
    <li>🔐 Registration (valid/invalid flow)</li>
    <li>🔑 Login / Logout / Forgot Password</li>
    <li>🔎 Product Search + Filters</li>
    <li>📄 Product Details Page</li>
    <li>❤️ Wishlist Management</li>
    <li>🛒 Add to Cart / Remove / Update Quantity</li>
    <li>💳 Checkout (Guest & Registered)</li>
    <li>📜 Order History Validation</li>
</ul>

<hr>

<h2>👥 Automation Team Members</h2>

<table>
  <tr>
    <th>Name</th>
    <th>Automation Responsibility</th>
    <th>Contact 📧</th>
  </tr>

  <tr>
    <td><strong>Rawan Mohammed</strong></td>
    <td>Checkout & Order History</td>
    <td>rawanmohammed99@gmail.com</td>
  </tr>

  <tr>
    <td><strong>Yasmin Ali Helmy</strong></td>
    <td>Search + Filters</td>
    <td>Yasmin.ali.helmy@gmail.com</td>
  </tr>

  <tr>
    <td><strong>Shaimaa Mansour</strong></td>
    <td>Product Page + Wishlist</td>
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
    <td>Cart & Mini Cart</td>
    <td>basantadel99@gmail.com</td>
  </tr>
</table>

<hr>

<h2>🛠️ Tech Stack</h2>

<ul>
    <li><strong>Java</strong></li>
    <li><strong>Selenium WebDriver</strong></li>
    <li><strong>TestNG</strong></li>
    <li><strong>Maven</strong></li>
    <li><strong>Extent Reports (HTML Reporting)</strong></li>
    <li><strong>Git / GitHub</strong></li>
</ul>

<hr>

<h2>📁 Automation Framework Structure</h2>

<pre>
SWT-DEPI-GraduationProject/
│
├── src/
│   ├── test/java/
│   │   ├── tests/
│   │   ├── pages/     ← POM files
│   │   ├── utils/     ← BrowserFactory, ConfigReader, etc.
│   │   ├── base/      ← BaseTest.java
│   │
│   ├── main/resources/
│       ├── config.properties
│       └── testdata.json
│
├── pom.xml
├── testng.xml
└── README.md
</pre>

<hr>

<h2>🧪 Automation Framework Features</h2>

<ul>
    <li>Page Object Model (POM) structure</li>
    <li>Centralized WebDriver setup (BaseTest)</li>
    <li>Automatic driver handling (WebDriverManager)</li>
    <li>Test data handling (JSON)</li>
    <li>HTML reporting with Extent Reports</li>
    <li>Reusable utilities</li>
    <li>Error handling + screenshot capture</li>
</ul>

<hr>

<h2>🔀 Git Branch Workflow</h2>

<p>The automation work is divided into separate branches:</p>

<pre>
main                     ← protected
feature/registration
feature/login-logout-forgetpassword
feature/search-filters
feature/product-wishlist
feature/cart-minicart
feature/checkout-orderhistory
</pre>

<p>
Each member commits only to their branch, then creates a Pull Request (PR) to merge into <strong>main</strong>.
</p>

<hr>

<h1>🛠 Installation & Setup Guide — Run Selenium Test Cases Locally</h1>

<p>
To execute the OpenCart automation test suite, you must install 
<strong>OpenCart locally</strong> and configure the automation framework to point to your local environment.
Follow the steps below.
</p>

<br>

<h2>1️⃣ Install OpenCart Locally</h2>

<p><strong>Recommended: Install using XAMPP</strong></p>

<ul>
    <li>Download XAMPP:<br> https://www.apachefriends.org/download.html</li>
    <li>Start these services:
        <ul>
            <li>Apache</li>
            <li>MySQL</li>
        </ul>
    </li>

    <li>Download OpenCart:<br> https://www.opencart.com/index.php?route=cms/download</li>

    <li>Extract OpenCart to:<br>
        <strong>C:/xampp/htdocs/opencartproject/</strong>
    </li>

    <li>Create a database:
        <ul>
            <li>Open phpMyAdmin → http://localhost/phpmyadmin</li>
            <li>Create database named: <strong>opencart</strong></li>
        </ul>
    </li>

    <li>Run the OpenCart installer:
        <ul>
            <li>Navigate to:<br> http://localhost/opencartproject/upload/</li>
            <li>Database settings:
                <ul>
                    <li>Host: localhost</li>
                    <li>Username: root</li>
                    <li>Password: (leave empty)</li>
                    <li>Database: opencart</li>
                </ul>
            </li>
            <li>Admin account:
                <ul>
                    <li>Email: admin@example.com</li>
                    <li>Password: admin123</li>
                </ul>
            </li>
        </ul>
    </li>

    <li>After installation:
        <ul>
            <li>Delete the <strong>/upload</strong> folder</li>
            <li>Move remaining files one level up into <strong>/opencartproject</strong></li>
        </ul>
    </li>
</ul>

<br>

<h2>2️⃣ Configure the Automation Framework</h2>

<p>Edit this file:</p>
<p><strong>src/main/resources/config.properties</strong></p>

<ul>
    <li>Set the base URL:</li>
</ul>

<p>
app.base.url = http://localhost/opencartproject/<br>
browser = chrome
</p>

<br>

<h2>3️⃣ Update Test Data (Optional)</h2>

<p>Inside:</p>
<p><strong>src/main/resources/testdata.json</strong></p>

<ul>
    <li>You can update:</li>
    <ul>
        <li>Login credentials</li>
        <li>Guest checkout data</li>
        <li>Registration data</li>
    </ul>
</ul>

<p>Example:</p>

<p>
"login.valid.email": "admin@example.com"<br>
"login.valid.password": "admin123"<br><br>

"checkout.guest.firstname": "John"<br>
"checkout.guest.lastname": "Doe"<br>
"checkout.guest.email": "guest@test.com"<br>
"checkout.guest.telephone": "0123456789"<br>
"checkout.guest.address1": "Street 1"<br>
"checkout.guest.city": "Cairo"<br>
"checkout.guest.postcode": "12345"<br>
"checkout.guest.country": "Egypt"<br>
"checkout.guest.region": "Aswan"
</p>

<br>

<h2>4️⃣ Run the Automation Tests</h2>

<ul>
    <li><strong>Run via IntelliJ / Eclipse:</strong><br>
        Right-click <strong>testng.xml</strong> → Run</li>

    <li><strong>Run entire project using Maven:</strong><br>
        mvn clean test</li>

    <li><strong>Run a specific test class:</strong><br>
        mvn -Dtest=LoginTests test</li>
</ul>

<br>

<h2>5️⃣ View Test Execution Reports</h2>

<ul>
    <li>Reports are generated here:<br>
        <strong>/test-output/ExtentReports/</strong>
    </li>
    <li>Open the file:<br>
        <strong>index.html</strong>
    </li>
</ul>

<br>

<h2>6️⃣ Required Tools</h2>

<ul>
    <li>Java 17 or above</li>
    <li>Maven 3+</li>
    <li>IntelliJ IDEA / Eclipse</li>
    <li>Google Chrome</li>
    <li>ChromeDriver (automatically installed via WebDriverManager)</li>
</ul>

<br>

<h2>7️⃣ Auto-Register Function (Optional)</h2>

<ul>
    <li>If login fails (user not found), the framework auto-creates the user</li>
    <li>Stores the email in: <strong>GlobalData.LAST_REGISTERED_EMAIL</strong></li>
    <li>Attempts login again automatically</li>
</ul>

<br>

<h2>🎉 Summary</h2>

<p>
Your automation environment is now fully configured.  
You can run all test suites against your local OpenCart instance and view detailed execution reports.
</p>


<h2>📌 Summary</h2>

<p>
This project represents a complete <strong>Selenium automation framework</strong> for the 
OpenCart platform.  
It demonstrates advanced QA automation practices, clean code structure, modular design, 
and team-based version control workflow.  
The project showcases real-world automation skills suitable for professional QA roles.
</p>

<hr>
