// Arrays and strings basics
// Build: g++ -std=c++17 02_arrays_strings.cpp -o arrays_strings

#include <iostream>
#include <string>
using namespace std;

int maxInArray(const int arr[], int n) {
    int best = arr[0];
    for (int i = 1; i < n; i++) best = max(best, arr[i]);
    return best;
}

bool isPalindrome(const string &s) {
    int i = 0, j = (int)s.size() - 1;
    while (i < j) {
        if (s[i] != s[j]) return false;
        i++; j--;
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cout << "Enter array size: ";
    cin >> n;
    int arr[1000];
    for (int i = 0; i < n; i++) cin >> arr[i];

    cout << "Max = " << maxInArray(arr, n) << "\n";

    cout << "Enter a word: ";
    string s;
    cin >> s;
    cout << (isPalindrome(s) ? "Palindrome" : "Not palindrome") << "\n";

    return 0;
}
