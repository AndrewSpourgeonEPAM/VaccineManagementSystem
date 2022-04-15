<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>VACCINE MANAGEMENT TOOL</title>
<script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
</head>
<style>
html {
	text-align: center;
}

body {
	 background-image:
		url('https://images.pexels.com/photos/8830482/pexels-photo-8830482.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2');
	background-repeat: no-repeat;
	background-size: cover; 
	
}
.drew button {
  position: flex;
  top: 50%;
  right: 0;
  left: 0;
  display: block;
  width: 240px;
  padding: 40px;
  margin: 0 auto;
  border: 0;
  cursor: pointer;
  border-radius: 2px;
  transform: translateY(-50%);
  box-shadow: 0 10px 20px -5px #94a6af;
  overflow: hidden;
}

.drew button:before,
.drew button:after {
  content: "";
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
}

.drew button:before {
  transform: scale(1);
  background-image: url("https://himalayasingh.github.io/button-hover-effect-1/img/bg.jpg");
  background-size: cover;
  transition: 0.3s ease transform;
  z-index: 1;
}

.drew button:after {
  background-color: #000;
  opacity: 0.16;
  z-index: 2;
}

.drew button div {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 3;
}

.drew button div:before,
.drew button div:after {
  position: absolute;
  top: 0;
  right: 0;
  left: 0;
  color: #fff;
  font-size: 30px;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  font-weight: bold;
  line-height: 1;
  text-align: center;
  padding: 25px 0;
  transition: 0.3s ease all;
}

.drew button div:before {
  content: "ANDREW";
  letter-spacing: 0;
  opacity: 1;
  transform: scale(1);
}

.drew button div:after {
  content: "SPOURGEON";
  letter-spacing: -10px;
  transform: scale(0);
  opacity: 0;
}

.drew button:hover:before {
  transform: scale(1.3);
}

.drew button:hover div:before {
  letter-spacing: 3px;
  opacity: 0;
  transform: scale(4);
}

.drew button:hover div:after {
  letter-spacing: 0;
  opacity: 1;
  transform: scale(1);
}

@font-face {
  font-family: Clip;
  src: url("https://acupoftee.github.io/fonts/Clip.ttf");
}
.sign {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 5%;
  background-image: radial-gradient(
    ellipse 50% 35% at 50% 50%,
    #6b1839,
    transparent
  );
  transform: translate(-50%, -50%);
  letter-spacing: 2;
  left: 50%;
  top: 50%;
  font-family: "Clip";
  text-transform: uppercase;
  font-size: 65px;
  color: #ffe6ff;
  text-shadow: 0 0 0.6rem #ffe6ff, 0 0 1.5rem #ff65bd,
    -0.2rem 0.1rem 1rem #ff65bd, 0.2rem 0.1rem 1rem #ff65bd,
    0 -0.5rem 2rem #ff2483, 0 0.5rem 3rem #ff2483;
  animation: shine 2s forwards, flicker 3s infinite;
}

@keyframes blink {
  0%,
  22%,
  36%,
  75% {
    color: #ffe6ff;
    text-shadow: 0 0 0.6rem #ffe6ff, 0 0 1.5rem #ff65bd,
      -0.2rem 0.1rem 1rem #ff65bd, 0.2rem 0.1rem 1rem #ff65bd,
      0 -0.5rem 2rem #ff2483, 0 0.5rem 3rem #ff2483;
  }
  28%,
  33% {
    color: #ff65bd;
    text-shadow: none;
  }
  82%,
  97% {
    color: #ff2483;
    text-shadow: none;
  }
}

.flicker {
  animation: shine 2s forwards, blink 3s 2s infinite;
}

.fast-flicker {
  animation: shine 2s forwards, blink 10s 1s infinite;
}

@keyframes shine {
  0% {
    color: #6b1839;
    text-shadow: none;
  }
  100% {
    color: #ffe6ff;
    text-shadow: 0 0 0.6rem #ffe6ff, 0 0 1.5rem #ff65bd,
      -0.2rem 0.1rem 1rem #ff65bd, 0.2rem 0.1rem 1rem #ff65bd,
      0 -0.5rem 2rem #ff2483, 0 0.5rem 3rem #ff2483;
  }
}

@keyframes flicker {
  from {
    opacity: 1;
  }

  4% {
    opacity: 0.9;
  }

  6% {
    opacity: 0.85;
  }

  8% {
    opacity: 0.95;
  }

  10% {
    opacity: 0.9;
  }

  11% {
    opacity: 0.922;
  }

  12% {
    opacity: 0.9;
  }

  14% {
    opacity: 0.95;
  }

  16% {
    opacity: 0.98;
  }

  17% {
    opacity: 0.9;
  }

  19% {
    opacity: 0.93;
  }

  20% {
    opacity: 0.99;
  }

  24% {
    opacity: 1;
  }

  26% {
    opacity: 0.94;
  }

  28% {
    opacity: 0.98;
  }

  37% {
    opacity: 0.93;
  }

  38% {
    opacity: 0.5;
  }

  39% {
    opacity: 0.96;
  }

  42% {
    opacity: 1;
  }

  44% {
    opacity: 0.97;
  }

  46% {
    opacity: 0.94;
  }

  56% {
    opacity: 0.9;
  }

  58% {
    opacity: 0.9;
  }

  60% {
    opacity: 0.99;
  }

  68% {
    opacity: 1;
  }

  70% {
    opacity: 0.9;
  }

  72% {
    opacity: 0.95;
  }

  93% {
    opacity: 0.93;
  }

  95% {
    opacity: 0.95;
  }

  97% {
    opacity: 0.93;
  }

  to {
    opacity: 1;
  }
}


</style>

<body>

	<br>
	<br>
	<div class="sign">
      <span class="fast-flicker">Va</span><span class="flicker">cc</span><span class="fast-flicker">in</span></span><span class="flicker">at</span><span class="fast-flicker">or</span> 
    </div>
	
	<a href="/registration">
		<button type="button" class="btn btn-primary position-relative">
			REGISTER <span
				class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-secondary">+
				<span class="visually-hidden">unread messages</span>
			</span>
		</button>
	</a>
	<br>
	<br>
	<br>
	<br>
	<a href="/userlogin">
		<button type="button" class="btn btn-dark position-relative">
			USER LOGIN
			<svg width="1em" height="1em" viewBox="0 0 16 16"
				class="position-absolute top-100 start-50 translate-middle mt-1 bi bi-caret-down-fill"
				fill="#212529" xmlns="http://www.w3.org/2000/svg">
			<path
					d="M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z" /></svg>
		</button>
	</a>
	<br>
	<br>
	<br>
	<br>
	<a href="/adminlogin">
		<button type="button" class="btn btn-primary position-relative">
			ADMIN LOGIN <span
				class="position-absolute top-0 start-100 translate-middle badge border border-light rounded-circle bg-danger p-2"><span
				class="visually-hidden">unread messages</span></span>
		</button>
	</a>
	<br>
	<br>
	<br>
	<h4>Made by</h4>
	<br>
	<br>
	<span class="drew">
	<button>
  <div></div>
</button>
</span>
</body>
</html>