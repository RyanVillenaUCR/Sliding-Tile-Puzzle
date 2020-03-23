(echo "1 1" | java -ea -cp temp/ Driver > local_results/triv_uni.txt)&
(echo "1 2" | java -ea -cp temp/ Driver > local_results/triv_mis.txt)&
(echo "1 3" | java -ea -cp temp/ Driver > local_results/triv_man.txt)&

(echo "2 1" | java -ea -cp temp/ Driver > local_results/veasy_uni.txt)&
(echo "2 2" | java -ea -cp temp/ Driver > local_results/veasy_mis.txt)&
(echo "2 3" | java -ea -cp temp/ Driver > local_results/veasy_man.txt)&

(echo "3 1" | java -ea -cp temp/ Driver > local_results/easy_uni.txt)&
(echo "3 2" | java -ea -cp temp/ Driver > local_results/easy_mis.txt)&
(echo "3 3" | java -ea -cp temp/ Driver > local_results/easy_man.txt)&

(echo "4 1" | java -ea -cp temp/ Driver > local_results/doable_uni.txt)&
(echo "4 2" | java -ea -cp temp/ Driver > local_results/doable_mis.txt)&
(echo "4 3" | java -ea -cp temp/ Driver > local_results/doable_man.txt)&

(echo "5 1" | java -ea -cp temp/ Driver > local_results/ohboy_uni.txt)&
(echo "5 2" | java -ea -cp temp/ Driver > local_results/ohboy_mis.txt)&
(echo "5 3" | java -ea -cp temp/ Driver > local_results/ohboy_man.txt)&

(echo "6 3 1 2 3 4 5 6 8 7 0 3" | java -ea -cp temp/ Driver > local_results/impos_uni.txt)&
(echo "6 3 1 2 3 4 5 6 8 7 0 3" | java -ea -cp temp/ Driver > local_results/impos_mis.txt)&
(echo "6 3 1 2 3 4 5 6 8 7 0 3" | java -ea -cp temp/ Driver > local_results/impos_man.txt)&
