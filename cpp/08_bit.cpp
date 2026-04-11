// Bit manipulation basics
// Build: g++ -std=c++17 08_bit.cpp -o bit

#include <iostream>
using namespace std;

bool isBitSet(int n, int pos) {
    return (n & (1 << pos)) != 0;
}

int setBit(int n, int pos) {
    return n | (1 << pos);
}

int clearBit(int n, int pos) {
    return n & ~(1 << pos);
}

int toggleBit(int n, int pos) {
    return n ^ (1 << pos);
}

int countBits(int n) {
    int cnt = 0;
    while (n) {
        n &= (n - 1);
        cnt++;
    }
    return cnt;
}

bool isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, pos;
    cout << "Enter n and bit position: ";
    cin >> n >> pos;

    cout << "Bit set? " << isBitSet(n, pos) << "\n";
    cout << "Set bit: " << setBit(n, pos) << "\n";
    cout << "Clear bit: " << clearBit(n, pos) << "\n";
    cout << "Toggle bit: " << toggleBit(n, pos) << "\n";

    cout << "Set bits count: " << countBits(n) << "\n";
    cout << "Power of two? " << isPowerOfTwo(n) << "\n";

    return 0;
}
