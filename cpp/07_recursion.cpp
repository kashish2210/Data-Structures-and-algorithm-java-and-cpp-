// Recursion basics
// Build: g++ -std=c++17 07_recursion.cpp -o recursion

#include <iostream>
using namespace std;

long long fact(int n) {
    if (n <= 1) return 1;
    return n * fact(n - 1);
}

int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}

int power(int a, int b) {
    if (b == 0) return 1;
    int half = power(a, b / 2);
    if (b % 2 == 0) return half * half;
    return a * half * half;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cout << "Enter n for factorial and fib: ";
    cin >> n;
    cout << "fact(" << n << ") = " << fact(n) << "\n";
    cout << "fib(" << n << ") = " << fib(n) << "\n";

    int a, b;
    cout << "Enter a and b for a^b: ";
    cin >> a >> b;
    cout << "power = " << power(a, b) << "\n";

    return 0;
}
