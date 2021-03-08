(async () => {

	const info = await (await fetch('http://localhost:8080/fds/webapi/user/info')).json()

	for (var key in info) {
		if (document.getElementById(key.toString())) {
			document.getElementById(key.toString()).value = info[key]
		}
	}

})()

document.getElementById('register').onclick = async e => {
	e.preventDefault()

	const data = new FormData(document.getElementById('form'))
	const value = Object.fromEntries(data.entries())
	const info = await (await fetch('http://localhost:8080/fds/webapi/user/info')).json()
	
	
	for (var key in value) {
		await (info[key] = value[key])
	}
		
	
	await fetch('http://localhost:8080/fds/webapi/user/udpate', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(info)
	})
	location.replace("http://localhost:8080/fds/accueil.html")
}


document.getElementById('cancel').onclick = async e => {
	e.preventDefault()
	const info = await (await fetch('http://localhost:8080/fds/webapi/user/info')).json()

	await fetch('http://localhost:8080/fds/webapi/user/remove', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(info["no_utilisateur"])
	})
	location.replace("http://localhost:8080/fds/accueil.html")
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
