git remote set-url origin https://github.com/DevCH43/Petagram.git
git config --global user.name "DevCH43"
git config --global color.ui true
git config core.fileMode false
git config --global push.default simple

git checkout master

git status

git add .
// git add src/

git commit -m "Petagram Update 01"

git push -u origin master

exit
