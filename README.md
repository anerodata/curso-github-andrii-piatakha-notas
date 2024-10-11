Curso básico de Git y Github
=======
Git es una herramienta de control de versiones. Se utiliza para documentar procesos de trabajo. Github es un portal para subir a la red el repositorio creado previamente con Git con el objetivo de ponerlo en común con otras personas. Los apuntes de este fichero _markdown_ corresponden a:
- Notas tomadas fruto de la experiencia
- El curso de Udemy [Git from Basics to Advanced: Practical Guide for Developers](https://www.udemy.com/course/git-learnit/?couponCode=ST17MT91224A)

## 1 - Comandos básicos
1. `git init`: sirve para iniciar git dentro de un directorio

2. `git status`: sirve para conocer el estado actual de nuestro repositorio

3. `git add nombre_fichero`: añade al area de almacenamiento un fichero que se encuentra en el directorio de trabajo. Cada vez que cambiamos un fichero y guardamos, hay que usar este comando. Si usamos un punto (.) en lugar de nombre_fichero añadiremos todos los ficheros al area de almacenamiento a la vez

4. `git checkout -- nombre_fichero`: retrocede el cambio efectuado, de manera que no hará falta correr git add nombre_fichero. Sería como hacer ctrl + z

5. `git diff nombre_fichero`: ver como ha cambiado el fichero antes de hacer git add sobre el

6. `git commit`: registra los cambios y añade los ficheros en su nueva versión al repositiorio. Hace un snapshot de la última versión del proyecto con sus cambios y modificaciones. Hay que darle un nombre a cada commit

7. `git commit -m "nombre del cambio"`: Hace lo mismo que el comando anterior sin abrir el fichero de commits

8. `git log`: muestra un registro con todas las versiones del repositorio 

9. `git checkout 43ea714582cb136a75813552fb85429628d67576` la cifra se refiere al hash del commit y permite retroceder a una versión anteriormente trackeada de nuestro repositorio

10. `git checkout master`: habiendo retrocedido a otra versión, nos devuelve al ultimo commit efectuado, la versión más reciente. Estando en otra rama distinta, nos permite cambiar a master

## 2 - Subiendo el repositorio a Github
1. `git remote add origin https://github.com/anerodata/curso-github.git`: vincula el repositorio local a ese repositorio online

2. `git push -u origin master`: subimos todos los cambios al repositorio remoto https://github.com/anerodata/curso-github.git vinculado al que tenemos en local

3. `git clone https://github.com/anerodata/curso-github.git`: descarga el repositorio online y lo deja en local

4. `git pull`: sirve para traerte todos los cambios del repositorio online al repositorio local 

Este [video](https://www.youtube.com/watch?v=HiXLkL42tMUde) de youtube está bastante bien para iniciarse

5. Estando fuera de `master`, y tras comitear, `git push --set-upstream origin branch-name` crea y establece en el repositorio remoto el nombre de la rama como destino y "empuja" los cambios hacia ella.

6. Como comentan en [Freecodecamp](https://www.freecodecamp.org/news/git-checkout-remote-branch-tutorial/#3pullchangesfromaremotebranch) `git checkout -b fix-failing-tests origin/fix-failing-tests` Crea la rama `fix-failing-tests`, tira de los cambios en la rama remota `fix-failing-tests` y nos cambia a ella

## 3 - Rama gh-pages 

Como documenta [flowsta](https://github.com/flowsta/github#rama-gh-pages), si nuestro repositorio es un proyecto web, podemos mostrarlo gracias a la rama gh-pages de github:

1. `git checkout -b gh-pages` crear rama gh-pages y cambiar de master a gh-pages

2. `git merge master` poner todo el contenido de master en gh-pages

3. `git push -u origin gh-pages` empujar los cambios locales a la rama gh-pages

4. Para tener la rama master y la rama gh-pages avanzando en paralelo añadimos estas dos lineas bajo [remote "origin"] en .git/config:

`push = +refs/heads/master:refs/heads/gh-pages`

`push = +refs/heads/master:refs/heads/master`

Ahora tendríamos el proyecto web renderizando en https://nombre-de-usuario.github.io/nombre-del-repositorio/

## 4 - Git from Basics to Advanced: Practical Guide for Developers

### 4.1 Comandos

- `git remote -v`: indica si hay una rama remota vinculada al repo local
- `git remote set-url origin [URL]`: cambia la URL remota vinculada a un repo
- `git branch`: lista las ramas locales
- `git branch -r`: lista las ramas remotas
- `git branch -a`: lista todas las ramas
- `git branch -d [rama]`: Elimina una rama
- `git push origin --delete feature/CAE-102` Elimina una rama remota
- `git switch -c [new_branch]`: Crea una nueva arama y te cambia a ella
- `git switch -`: Te lleva a main o master
- `git switch -`: Te lleva al último estado de la rama en la que estés
- `git commit -a`: Añade todo al stage y commitea
- `git commit --amend --no-edit`: Modifica el commit sin cambiar el mensaje
- `git fetch`: Trae los cambios al estado local, `git merge` después integraría los cambios traídos en el código
- `git pull`: Es la combinación de los dos anteriores
- `git push -u origin [rama]` pushea los cambios a una nueva rama remota recien creada

#### `git reset`

![git reset](https://github.com/anerodata/curso-github-andrii-piatakha-notas/blob/main/img/git-reset.png)

- `git reset --hard HEAD~1`: restaura, recuperando el contenido de ficheros cambiados o borrados, y el contenido nuevo que se introdujo en el commit anterior. Situa el estado en el penúltimo commit, borrando el último. HEAD es el último commit
- `git rebase`: Rebase changes from another branch 
- `git pull --rebase [rama]`: `git fetch` + `git rebase` (mejor que el anterior). `git pull --rebase origin main` trae los cambios del repositorio remoto antes de poner nuestro codigo en lo alto del historial.
- Después de resolver conflictos y añadir al _stage_ los cambios: `git rebase --continue`
- `git rebase --abort`: Detiene el rebase
- `git rebase -i HEAD~3`: Hace un rebase interactivo de los últimos 3 commits. Permite por ejem cambiar el nombre de un commit pasado. Buena práctica: Modificar commits de mi rama, pero no del arbol de main por ejemplo. También podemos hacer squash con este modo.
- prueba
- `git push -f`: Habitualmente tendremos que hacerlo si usamos rebase porque, rebase cambia el historial de git. También si hemos hecho un `git reset --hard HEAD~1`. Borrará cambios que están en el repositorio remoto. Se recomienda usar solo con las ramas personales.
- `git push --force-with-lease`: Menos arriesgada. No sobreescribe trabajo en la rama remota si más commits fueron añadidos a la rama remota  por otro compañero. En este caso, el `push` fallará
- `git reset 5bbce --soft`:  retorna el estado de HEAD a ese commit, colocando en el stage area los cambios de los commits posteriores, por lo tanto habría que hacer un commit
- `git reset 5bbce --mixed` (default): retorna el estado de HEAD a ese commit, colocando en el working area los cambios de los commits posteriores, por lo tanto habría que hacer un git add y después commit.
- `git reset 5bbce --hard`:  retorna el estado de HEAD a ese commit, eliminando los cambios de los commits posteriores, por lo tanto habría que hacer un commit
- `git reset --hard HEAD`: resetea el estado de la rama a como está en el puntero del HEAD
- `git fetch --all`: Trae el estado más fresco del repositorio remoto. `git reset --hard origin/[branch]` Establecemos el estado de nuestra rama al mismo estado al que esta la remota
- `git stash`: Esconde los cambios en el working tree o en el stage area
- `git stash`: Aplica dichos cambios del working tree
- `git stash list`: Lista la pila (stack) de stashes
- `git stash apply stash@{1}`: Aplica los cambios del puesto 1 en la pila (stack). Si tienes cambios en el stage area git te pedirá que commitees o stahees los cambios porque se borrarían al hacer merge
- `git stash save "mis cambios de prueba"`: Guardaría en stash los cambios con ese nombre
- `git stash pop`: Aplica el último stash y lo elimina de la lista. También funciona con los ID
- `git stash -u`: Guardaría en el stash los elementos no trackeados, los que aun no están en el working tree porque se acaban de crear
- `git stash -a`: Guardaría en el stash todo, los elementos no trackeados y los cambios en los ficheros ignorados por git
- `git stash branch [new_branch]`: Cambia a una nueva rama e introduce los cambios almacenados en el último stash. Con un ID introduciría los cambios guardados en el stash del ID
- `git stash show`: Muestra los ficheros que cambia el último stash almacenado. `git stash show stash@{1}` o directamente `git stash show 1` lo haría con un stash concreto
- `git stash show -p`: Muestra la diferencia del último stash almacenado. `git stash show -p stash@{1}` o directamente `git stash show -p 1` lo haría con un stash concreto
- `git stash drop stash@{0}`: Elimina el stash 0
- `git stash clear`: Limpia la pila de stashes
- `git reglog`: Cuando trabajamos con git y movemos punteros, git silenciosamente graba cual es nuestro puntero HEAD y como luce. Cada vez que creamos un nuevo snapshot o cambiamos ramas, el reflog se actualiza. Dicho comando muestra información sobre el reflog.
- `git log -g`: Muestra el historial de commits con la referencia de reflog
Hacemos un reset hard a un commit anterior
- `g branch lost_changes [sha_commit]`: Crearia una rama lost_changes con los commits borrados en un reset hard previo El sha commit lo hemos recuperado con git log -g
- `g log lost_changes`: nos mostraria el log de esa rama
- `git reflog --since="1.hour"`: Muestra el reflog desde hace una hora. La info para reflog se almacena durante 90 días
- `git reset --hard HEAD@{7}` Habiendo consultado el reflog con el commit anterior, podriamos ejecutar este comando siendo 7 el estado del HEAD que queremos recuperar
- `git cherry-pick [hash_commit] [hash_commit]`: Crearía un nuevo commit (con un nuevo hash) con el resultado de los dos commits mencionados en el comando
Reglas del cherry-pick:
1. Mejor merge o rebase cuando sea posible
2. Evitar crear duplicaciones: es OK crear un cherry pick de una rama que se va a borrar o va a eliminar esos commits. El problema es tener dos ramas con commits duplicados
3. A veces mejora el resultado usar cherry-pick así: `git cherry-pick-x [hash_commit]` porque añade información al commit que va a crear el cherry-pick

### 4.2 Consejos de Andrii Piatakha

Relacionados con `git rabase`. Recominda rebase para no añadir un commit que no aporta información al hacer merge.

1. Always create branches from master
2. Force update and change commit history only on your branches
3. Use `--force-with-lease` instead of -f
4. Always rebase on the origin master branch before creating a pull request
