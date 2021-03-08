form.oninput = e => {
	e.preventDefault()
	checkInputs(e.target.id)
	
}

(()=> {
	if (document.cookie.indexOf('user') > -1 ) {
		console.log("dsdqsdqsdsq")
		json = JSON.parse(decodeURIComponent(Cookies.get('user')))
		document.getElementById("username").value = json['username']
		document.getElementById("password").value = json['password']
		document.getElementById("remember").checked = true
		
}
})()



document.getElementById('register').onclick = async (e) => {
	
	e.preventDefault()

	const data = new FormData(document.getElementById('form'))
	const value = Object.fromEntries(data.entries())
	
	const response = await fetch('http://localhost:8080/fds/webapi/login/register', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(value)
	})
	
	if (response.ok) {
		
	} else {
		document.getElementById('alert').style.display = 'revert';
	}
}

document.getElementById('annulerVente').onclick = async (e) => {
	
	e.preventDefault()

	const data = new FormData(document.getElementById('form'))
	const value = Object.fromEntries(data.entries())
	
	const response = await fetch('http://localhost:8080/fds/webapi/login/register', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(value)
	})
	
	if (response.ok) {
		
	} else {
		document.getElementById('alert').style.display = 'revert';
	}
}

document.getElementById('cancel').onclick = async (e) => {
	e.preventDefault()
	location.replace("http://localhost:8080/fds/accueil.html")
	}
