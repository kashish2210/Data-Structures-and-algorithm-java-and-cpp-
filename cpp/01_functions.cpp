// Functions, pass by value/reference, and simple utilities
// Build: g++ -std=c++17 01_functions.cpp -o functions

#include <iostream>
using namespace std;

int add(int x, int y) {
    return x + y;
}

void increment(int &x) {
    x++; // reference updates caller
}

void swapValues(int &a, int &b) {
    int t = a;
    a = b;
    b = t;
}

long long factorial(int n) {
    long long ans = 1;
    for (int i = 2; i <= n; i++) ans *= i;
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a = 4, b = 7;
    cout << "add(a,b) = " << add(a, b) << "\n";

    increment(a);
    cout << "after increment, a = " << a << "\n";

    swapValues(a, b);
    cout << "after swap, a = " << a << ", b = " << b << "\n";

    cout << "Enter n for factorial: ";
    int n;
    cin >> n;
    cout << "factorial(" << n << ") = " << factorial(n) << "\n";

    return 0;
}
