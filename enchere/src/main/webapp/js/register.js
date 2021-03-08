document.getElementById('register').onclick = async (e) => {
	
	e.preventDefault()

	const data = new FormData(document.getElementById('form'))
	const value = Object.fromEntries(data.entries())
	await console.log(value)
	const response = await fetch('http://localhost:8080/fds/webapi/login/register', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(value)
	})
	
	if (response.ok) {
		window.location.replace("http://localhost:8080/fds/accueil.html")
	
	} else {
		document.getElementById('alert').style.display = 'revert';
	}
	
}

document.getElementById('cancel').onclick = e => {
	e.preventDefault()
	window.location.replace("http://localhost:8080/fds/accueil.html")
}

form.oninput = e => {

	e.preventDefault()
	checkInputs(e.target.id)
}



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