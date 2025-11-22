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

<h2>📌 Summary</h2>

<p>
This project represents a complete <strong>Selenium automation framework</strong> for the 
OpenCart platform.  
It demonstrates advanced QA automation practices, clean code structure, modular design, 
and team-based version control workflow.  
The project showcases real-world automation skills suitable for professional QA roles.
</p>

<hr>
