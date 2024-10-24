#include <stdio.h>

int main() {
    FILE *inputFile = fopen("ProgTestSae/2.in", "r");
    FILE *outputFile = fopen("ProgTestSae/2.ans", "w");

    if (inputFile == NULL || outputFile == NULL) {
        fprintf(stderr, "Error opening file.\n");
        return 1;
    }

    int h, m;
    fscanf(inputFile, "%d %d", &h, &m);
    int mirroredH = (12 - h) % 12;
    if (mirroredH == 0) mirroredH = 12;
    int mirroredM = (60 - m) % 60;
    if (mirroredM == 0) mirroredM = 0;
    fprintf(outputFile, "%d %d\n", mirroredH, mirroredM);

    fclose(inputFile);
    fclose(outputFile);

    return 0;
}