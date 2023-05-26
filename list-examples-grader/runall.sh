while read p; do
  bash grade.sh $p
done <repos.txt
