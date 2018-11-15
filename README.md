# digital_library

<H3>Introduction</H3>

A digital library is a collection of documents in organized electronic form, available on the Internet or on server database. Depending on the specific library, a user may be able to access magazine articles, books, papers, images, sound files, and videos.  Digital Library is a concept that is providing solution to space limitation and resource limitation of physical libraries. Several terms have been coined at different times to represent the concept of library without books, Libraries having influence on computer readable format or having access to influence on digitized or digital format. 

The term digital library may mean different things to different people, but it is not merely a collection of electronic information. It is an organized system of digital information that can serve as a rich resource for its user community.

<H3>Solution</H3>
From this new Digital Library System provide most smooth and flexible solution for a digital library.  The system has used centralized database to keep several data objects. Reader computers are facilitate using Java Remote Method Invocation Technology (RMI). 

This Digital Library System will contain following facilities,
<H4>Server Side facilities</H4>
<ul>
<li>Managing different kinds of data objects</li>
<li>Keeping logger details</li>
<li>Real time client computer observation</li>
<li>Client side USB detection</li>
</ul>

<H4>Client Side Facilities</H4>
<ul>
<li>Search and preview audios, videos and other resources</li>
<li>Let to copy texts to text files and save them in USB</li>
<li>Let to get screenshots and save them in USB</li>
<li>Allow to suggest new materials</li>
<li>Let to comment or rate materials</li>
  </ul>
  
<h3>Technology Used</h3>
<b>Languages :</b> Java 8 (Java RMI, JDBC, JFX Media API,Collection Framework,), MySQL<br>
<b>Architecture :</b> Client Server Architecture with Remote Method Invocation<br>
<b>Design Patterns :</b> Observer, Factory, DAO

<h3>Special Features</h3>
<h4>Audio+Video Player</h4>
<img src="https://i.imgur.com/nV4Wzi8.jpg">
JavaFX media framework has been used to build this media player. Play, pause, Stop buttons, ScreenShot button and a timeline has integrated with the player. Both Audio and Video are supported. 
<br><br>  Media Player is opening as a JFrame, but JFXPanel has used to hold all componts. JavaFX media API is used to perform multimedia activities. While playing a video, user can take screen shots of certain screen using Screenshot button. Screenshots are planned to be saved in an external pen drive. Player has connected with an USB detector class. The USB detector class can recognize whether an USB has plugged in and whether it is a pen drive. Then directly save the screenshot in pen drive, if available. 
