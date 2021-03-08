(async () => {

	const id = await fetch('http://localhost:8080/fds/webapi/session')
	if (id.ok) {
		document.getElementById('nav1').style.display = "flex"
		document.getElementById('container2').style.display = "flex"
		document.getElementById('nav2').style.display = "none"
	} else {
		document.getElementById('nav1').style.display = "none"
		document.getElementById('container2').style.display = "none"
		document.getElementById('nav2').style.display = "flex"
	}

	const categorie = await (await fetch('http://localhost:8080/fds/webapi/article/categorie')).json()
	const select = document.getElementById('select')
	for (var key in categorie) {
		select.innerHTML += `<option value="${categorie[key].no_categorie}"> ${categorie[key].libelle}</option>`
	}
}
)()

const getArticle = async () => {

	const articles = await (await fetch('http://localhost:8080/fds/webapi/article')).json()
	const wall = document.getElementById('wall')
	const search_value = document.getElementById('search_value').value
	const categorie = document.getElementById('select').value
	wall.innerHTML = ''
	
	for (var key in articles) {
		if ((categorie == "all" || categorie == articles[key].no_categorie) && (search_value == articles[key].nom_article || search_value == "")) {

			wall.innerHTML += `<div class="item">
			<img src="http://localhost:8080/fds/img/${articles[key].nom_article}.jpg" alt="lgo">
			<div class="detail">
				<label for="name">${articles[key].nom_article}</label> 
				<label for="name">Prix :${articles[key].prix_vente}</label>
				<label for="name">Fin de l'enchÃ¨re :${articles[key].date_fin_encheres}</label> 
				<label for="name">Vendeur :${articles[key].no_utilisateur}</label>
			</div>
		</div>`
		}
	}
}

document.getElementById('search').onclick = e => {
	e.preventDefault(),
		getArticle()
}
