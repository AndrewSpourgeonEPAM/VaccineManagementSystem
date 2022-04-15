<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/fc09389be9.js" crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>"${title}"</title>
<style >

@import url("https://fonts.googleapis.com/css2?family=Poppins&display=swap");

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

*:focus,
*:active {
  outline: none !important;
  -webkit-tap-highlight-color: transparent;
}

html,
body {
  display: grid;
  height: 100%;
  width: 100%;
  font-family: "Poppins", sans-serif;
  place-items: center;
  background-image:url("https://images.pexels.com/photos/1612353/pexels-photo-1612353.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
	background-repeat: no-repeat;
	background-size: cover;
}

.wrapper {
  display: inline-flex;
  list-style: none;
}

.wrapper .icon {
  position: relative;
  background: #ffffff;
  border-radius: 50%;
  padding: 15px;
  margin: 10px;
  width: 110px;
  height: 110px;
  font-size: 45px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  transition: all 0.2s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

.wrapper .tooltip {
  position: absolute;
  top: 0;
  font-size: 16px;
  background: #ffffff;
  color: #ffffff;
  padding: 5px 8px;
  border-radius: 5px;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
  opacity: 0;
  pointer-events: none;
  transition: all 0.3s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

.wrapper .tooltip::before {
  position: absolute;
  content: "";
  height: 8px;
  width:8px;
  background: #ffffff;
  bottom: -3px;
  left: 50%;
  transform: translate(-50%) rotate(45deg);
  transition: all 0.3s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

.wrapper .icon:hover .tooltip {
  top: -45px;
  opacity: 1;
  visibility: visible;
  pointer-events: auto;
}

.wrapper .icon:hover span,
.wrapper .icon:hover .tooltip {
  text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.1);
}

.wrapper .facebook:hover,
.wrapper .facebook:hover .tooltip,
.wrapper .facebook:hover .tooltip::before {
  background: #1877F2;
  color: #ffffff;
}

.wrapper .twitter:hover,
.wrapper .twitter:hover .tooltip,
.wrapper .twitter:hover .tooltip::before {
  background: #1DA1F2;
  color: #ffffff;
}

.wrapper .instagram:hover,
.wrapper .instagram:hover .tooltip,
.wrapper .instagram:hover .tooltip::before {
  background: #E4405F;
  color: #ffffff;
}

.wrapper .github:hover,
.wrapper .github:hover .tooltip,
.wrapper .github:hover .tooltip::before {
  background: #333333;
  color: #ffffff;
}

.wrapper .youtube:hover,
.wrapper .youtube:hover .tooltip,
.wrapper .youtube:hover .tooltip::before {
  background: #CD201F;
  color: #ffffff;
}
a {
    text-decoration:none;
    color: black;
}
a:hover{
 text-decoration:none;
    color: white;
}
h1{
color:white;
}
</style>
</head>
<body >
<h1>User Dashboard</h1>
<ul class="wrapper">

  <li class="icon facebook">
    <span class="tooltip">Locations</span>
    <a href="/vaccinedata">
    <span><i class="fa-solid fa-eye"></i></span>
    </a>
  </li>
  
  <li class="icon twitter">
    <span class="tooltip">Dose 1</span>
    <a href="/bookdoseone">
    <span><i class="fa-solid fa-syringe"></i></span>
    </a>
  </li>
  <li class="icon instagram">
    <span class="tooltip">Dose 2</span>
    <a href="/bookdosetwo">
    <span><i class="fa-solid fa-syringe"></i></span>
    </a>
  </li>
  <li class="icon github">
    <span class="tooltip">Fun Fact</span>
    <a href="/funfact">
    <span><i class="fa-solid fa-heart-circle-bolt"></i></span>
    </a>
  </li>
  <li class="icon twitter">
    <span class="tooltip">Profile</span>
    <a href="/userprofile">
    <span><i class="fa-solid fa-id-card"></i></span>
    </a>
  </li>
  <li class="icon youtube">
    <span class="tooltip">Delete account</span>
    <a href="/deleteuser">
    <span><i class="fa-solid fa-heart-crack"></i></span>
    </a>
  </li>
  <li class="icon facebook">
    <span class="tooltip">Logout</span>
    <a href="/dashboard">
    <span><i class="fa-solid fa-person-through-window"></i></span>
    </a>
  </li>

</ul>



</body>
</html>