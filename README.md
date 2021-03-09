# Spigot Web Framework
The official Git for the Spigot Web Framework

To date we Support any Minecraft Server like Bukkit, Spigot and Bungee.

![About](https://i.ibb.co/Cs6BxFQ/image.jpg)

# Supported and Tested Minecraft Server Versions
| Spigot        | Bungee        |
|:-------------:|:-------------:|
| 1.16.x        | Since Minecraft 1.13.x |
| 1.13.x        |               |
| 1.12.2 (Paper)|               |

If you have any trouble with an other Spigot/Bungee Version, feel free to leave a ticket. If you have successfully used SWF on any other platform, feel free to create a ticket.

# About
This is the official Development Kit for the Spigot Web Framework -- A powerfull WebServer based on your Minecraft Bukkit, Spigot and/or Bungeecord server

We feature multiple customisatzion features, like:
- Custom Website Templates
- Module Programming for adding new, dynamic content
- A powerfull Website generator
- Fileserver for serving your own content
- Style-Support
- and much more

# Setup
If you are new to SWF, here is an quick installation guide.
* Setup your Server as usual
* Copy the Plugin Jar into your Plugins Folder
* Run the Server once
* Shutdown your server
* Copy the Example Website from this repository
* Paste it into the Plugins (SWF!) Folder

# Static Pages
If you don't want to use our integrated WebBuilder, you can upload static Websites as .html files to the ```WebServer``` folder.

You need to Change the Default-Page entry in the settings to your main .html file (probably index.html).

# Configuration
Our Serversoftware is fully customizable and Supports SSL and Forcing SSL Traffic.
```yaml
#The IP-Address the webserver will listen too.
#Leave blank for listening to all addresses.
IP-ADDRESS: 

#The webservers port it will listen too.
PORT: 80

#The webservers SSL-Port for secure connections.
SSL-PORT: 443

#Should the server use SSL for secure connections?
Use-SSL: false

#Forces HTTP connections to be HTTPS
Force-SSL: false

#The FULL Path to the SSL-Cert-File
SSL-CERT: /

#The FULL Path to the SSL-Key-File
SSL-KEY: /

#Turns on the local Logger
Logger: true

#The default Page that shows when a user connects to the webserver. Can link to .html files.
Default-Page: /

#The 404-Errorpage. You can also use WebBuilder links here!
404-SITE: 404.html

#The default stylesheet the WebBuilder uses for the templates.
#Path: /SpigotWebFramework/WebBuilder/Styles
Stylesheet: style.css
```

# WebBuilder
The WebBuilder is our way to help every Minecraft-Server to get an awesome website, without knowing anything about HTML, JS or anything else!

## Footer and Navigation
The footer.json and navigation.json are very important in SWF (As seen in https://github.com/SteffTek/swf-dev-kit/issues/2). You at least have to have
```json
[]
```
in both files, so the SWF WebBuilder can interpret the JSON Files.

**Example navigation.json File**
```json
[
	{
		"name":"Home", #Link Name
		"url":"/" #URL to that Link

	},
	{
		"name":"Server",
		"url":"/"

	},
	{
		"name":"Gamemodes", #Link Name
		"url":"DROPDOWN", #URL Type Dropdown makes it a custom Dropdown
		"dropdown":[
			{
				"name":"Survival", #Link Name
				"url":"/" #Link
			},
			{
				"name":"Creative",
				"url":"/"
			}

		]
	}
]
```

**Example footer.json File**
```json
[
	{
		"name":"Link", #Link Name
		"url":"/" #URL to that Link

	}
]
```
---
And finally...
**Example index.json File**
```json
{
	"name":"Start | SWF", #Title as seen in an Webbrowser
	"url":"/index", #URL which the server registers
	"alias":"/", #Alias of the URL, necessary if index file.
	"template":"SIDEBAR", #Template Used. There are 2 Main Templates integrated. MAIN and SIDEBAR (Sidebar has a Sidebar.)
	"params":[ #The Params are the content of our webpage
		"[HEADER]THE BEST MINECRAFT CAN BE",# Title
		"[TEXT]Welcome to the&nbsp;<b>SpigotWebFramework</b>", #Simple Text. HTML is Supported.
		"[IMG]mc.png", #Image URL Loaded from the Static WebServer.
		"[TEXT]More Information about our framework will follow!",
		"[HEADER:SIDEBAR]PLAYERLIST", #Tell a Header Element to be loaded inside the Sidebar.
        "[MODULE:SIDEBAR:LIVE]MODULENAME", ##Module with name MODULENAME is Live Updated (every Second, needs JQuery enabled)
		"[HTML]<h3>You can insert normal HTML-Tags as well!</h3>"
	]
}
```

# Templates
You have to create a folder (WebBuilder/Templates/FOLDER). Inside you place your template.json and your linked HTML File. The name you set up in the JSON is the name you place inside your WebBuilder. (From Issue https://github.com/SteffTek/swf-dev-kit/issues/1)

Templates are built around Layouts and Styles. Feel free to have a look at the Example Template.
## Template Config
```json
{
	"name":"Test Template", 
	"file":"index.html",
	"author":"SteffTek"
}
```
* The template name represents the Template inside SWF Webbuilder Files
* The template file needs to point to an .html file inside the same folder as the Config file.
* You are the Author ;)
## Template File
```html
<!--
    This could be your Web-Template.
    Imagine This as your ordinary HTML-File
-->
[MYWINDOW] 
<!--
    This above is a Custom Tag.
    You can use this in WebBuilder Files like the "SIDEBAR" Tag.
-->

<!--Supported/Hardcoded Tags are: 

[TITLE] <-- For the Tab-Title in your Browser

[NAVIGATION]
[MAINWINDOW]
[SIDEBAR]
[FOOTER]
-->
```

## Template Example - Sidebar
Below you find the official Sidebar Template as it's delivered via SWF.

To add Custom Tags, simple put the Tag-Name inside square brackets (e.g. [NAME]). Inside your WebBuilder File you can than use that custom tag instead of MAIN or SIDEBAR.
```html
<html>
    <head>
        <!--Template by SteffTek-->

        <!--Style-->
        <link rel="stylesheet" href="template_style">

        <!--Meta-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        <!--Misc-->
        <title>[TITLE]</title>
        <link rel="icon" href="assets/favicon.png">

        <!--JS-->
        <script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
        
    </head>
    <body>
        <div class="navigation">
            [NAVIGATION]
        </div>
        <div class="spacer">
            <img src="assets/header.png" alt="">
        </div>
        <div class="holder">
            <div class="mainview">
                [MAINWINDOW]
            </div>
            <div class="sideview">
                [SIDEWINDOW]
            </div>
        </div>
        <div class="footer">
            [FOOTER]
        </div>
    </body>
</html>
```

# Modules
Modules are a way to generate more Complex HTML structures inside your webserver, like an live PlayerList.
To simply use Modules, pack the Module Jar inside the Modules folder.

## Writing Modules
Modules have 3 Main Functions:
* OnEnable,
* OnDisable and
* generateResponse

Inside the Devkit there is an Example Module. Feel free to use and change it.

A module.yml is required for modules to work properly.
```yaml
main: de.SteffTek.Playerlist.Main #Main Class
name: Playerlist #Name registered inside SWF
version: 1.0 #Version
environment: spigot #Environment, e.g. spigot or bungee
author: SteffTek #You ;)
```

# Bug-Report
Please use this Repo to submit Bugs for both, the framework it self and the dev-kit!
