// Math utilities: gcd, lcm, fast power (mod)
// Build: g++ -std=c++17 09_math_utils.cpp -o math_utils

#include <iostream>
using namespace std;

long long gcd_ll(long long a, long long b) {
    while (b != 0) {
        long long t = a % b;
        a = b;
        b = t;
    }
    return a;
}

long long lcm_ll(long long a, long long b) {
    return a / gcd_ll(a, b) * b;
}

long long modPow(long long a, long long b, long long mod) {
    long long res = 1 % mod;
    a %= mod;
    while (b > 0) {
        if (b & 1) res = (res * a) % mod;
        a = (a * a) % mod;
        b >>= 1;
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long a, b;
    cout << "Enter a and b for gcd/lcm: ";
    cin >> a >> b;
    cout << "gcd = " << gcd_ll(a, b) << "\n";
    cout << "lcm = " << lcm_ll(a, b) << "\n";

    long long base, exp, mod;
    cout << "Enter base, exp, mod: ";
    cin >> base >> exp >> mod;
    cout << "modPow = " << modPow(base, exp, mod) << "\n";

    return 0;
}
