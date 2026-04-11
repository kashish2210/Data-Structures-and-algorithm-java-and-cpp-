// Basics: I/O, types, operators, loops, and simple tasks
// Build: g++ -std=c++17 00_basics.cpp -o basics

#include <iostream>
#include <string>
#include <limits>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Basic types
    int a = 5;
    long long big = 1'000'000'000LL;
    double pi = 3.14159;
    char ch = 'A';
    bool ok = true;

    cout << "Types: " << a << " " << big << " " << pi << " " << ch << " " << ok << "\n";

    // Input with spaces (getline)
    cout << "Enter a line: ";
    string line;
    getline(cin, line);
    if (line.empty()) {
        // If first getline reads empty due to previous input, read again
        getline(cin, line);
    }
    cout << "You typed: " << line << "\n";

    // Example 1: sum of n numbers
    cout << "Enter n and n numbers: ";
    int n;
    if (!(cin >> n)) return 0;
    long long sum = 0;
    for (int i = 0; i < n; i++) {
        long long x;
        cin >> x;
        sum += x;
    }
    cout << "Sum = " << sum << "\n";

    // Example 2: count digits in a number
    cout << "Enter an integer to count digits: ";
    long long num;
    cin >> num;
    if (num == 0) {
        cout << "Digits = 1\n";
    } else {
        long long temp = llabs(num);
        int digits = 0;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        cout << "Digits = " << digits << "\n";
    }

    return 0;
}
