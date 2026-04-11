// Vector and 2D vector basics
// Build: g++ -std=c++17 03_vectors.cpp -o vectors

#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> v = {5, 2, 9};
    v.push_back(7);

    cout << "Vector: ";
    for (int x : v) cout << x << " ";
    cout << "\n";

    // 2D vector (matrix)
    int rows = 2, cols = 3;
    vector<vector<int>> mat(rows, vector<int>(cols, 0));

    int val = 1;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            mat[i][j] = val++;
        }
    }

    cout << "Matrix:\n";
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cout << mat[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
