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

function checkInputs(input) {
	const element = document.getElementById(input)
	const value = element.value.trim()
	if (value === '') {
		const form = element.parentElement
		form.querySelector('small').innerText = 'Champ vide'
		form.className = 'form-control error'
	} else {
		element.parentElement.className = 'form-control success'
	}
}

document.onsubmit = async (e) => {
	e.preventDefault()
	response = await fetch('http://localhost:8080/fds/webapi/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			username: username.value,
			password: password.value
		})
	})
	if (response.ok) {
		
		if (document.getElementById("remember").checked) {
			const user = await response.json()
			await Cookies.set('user', JSON.stringify(user));
		} 
		document.getElementById('alert').style.display = 'none';
		window.location.replace("http://localhost:8080/fds/accueil.html")
	} else {
		document.getElementById('alert').style.display = 'revert';
	}
}
