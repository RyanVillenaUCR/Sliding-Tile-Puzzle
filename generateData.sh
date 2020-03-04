(echo "1 1" | java -ea -cp temp/ Driver > results/triv_uni.txt)&
(echo "1 2" | java -ea -cp temp/ Driver > results/triv_mis.txt)&
(echo "1 3" | java -ea -cp temp/ Driver > results/triv_man.txt)&

(echo "2 1" | java -ea -cp temp/ Driver > results/veasy_uni.txt)&
(echo "2 2" | java -ea -cp temp/ Driver > results/veasy_mis.txt)&
(echo "2 3" | java -ea -cp temp/ Driver > results/veasy_man.txt)&

(echo "3 1" | java -ea -cp temp/ Driver > results/easy_uni.txt)&
(echo "3 2" | java -ea -cp temp/ Driver > results/easy_mis.txt)&
(echo "3 3" | java -ea -cp temp/ Driver > results/easy_man.txt)&

(echo "4 1" | java -ea -cp temp/ Driver > results/doable_uni.txt)&
(echo "4 2" | java -ea -cp temp/ Driver > results/doable_mis.txt)&
(echo "4 3" | java -ea -cp temp/ Driver > results/doable_man.txt)&

(echo "5 1" | java -ea -cp temp/ Driver > results/ohboy_uni.txt)&
(echo "5 2" | java -ea -cp temp/ Driver > results/ohboy_mis.txt)&
(echo "5 3" | java -ea -cp temp/ Driver > results/ohboy_man.txt)&

(echo "6 1 1 2 3 4 5 6 8 7 0 3" | java -ea -cp temp/ Driver > results/impos_uni.txt)&
(echo "6 2 1 2 3 4 5 6 8 7 0 3" | java -ea -cp temp/ Driver > results/impos_mis.txt)&
(echo "6 3 1 2 3 4 5 6 8 7 0 3" | java -ea -cp temp/ Driver > results/impos_man.txt)&
