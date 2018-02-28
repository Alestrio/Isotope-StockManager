**ISOTOPE**

## Informations générales:

- Version actuelle : Hydrogène (H)

- Types de consommables supportés :
	- Visserie
	- Plaques
	- Cylindres
	- Bobines d'impression 3D
	
---

## Comment contribuer ?

- Par ajout de fonctionnalités ou corrections de bugs (créer un pull request)

---

## Environnement de développement

- Le projet a besoin de
	- SceneBuilder
	- e(fx)clipse
	- JDBC avec les drivers PostgreSQL
	- Une base de données SQL avec les templates donnés dans le dossier "db"

---

## Déploiement

- En l'absence d'installateur, il faut placer le jar dans un dossier, puis rajouter le fichier donné dans le dossier "deployement",
	de là, il faudra rentrer l'addresse du serveur dans le fichier susnommé.

- Il faudra aussi installer un serveur PostGreSQL, et importer la base de données se trouvant dans le dossier "db".

--

## Gestion de version

- Merci d'utiliser Git pour commit et créer des pull requests.

--

## Auteur(s)

- Alexis LEBEL (Travail initial)

## License

- Ce projet n'est pas sous licence, cependant, tant qu'une version publique de ce projet n'est pas sortie, merci de ne pas
	distribuer de version debug ou release.