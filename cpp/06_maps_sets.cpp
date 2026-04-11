// Set, unordered_set, map, unordered_map basics
// Build: g++ -std=c++17 06_maps_sets.cpp -o maps_sets

#include <iostream>
#include <set>
#include <unordered_set>
#include <map>
#include <unordered_map>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    set<int> st = {5, 2, 2, 9, 1};
    cout << "Set (sorted unique): ";
    for (int x : st) cout << x << " ";
    cout << "\n";

    unordered_set<int> ust;
    ust.insert(3);
    ust.insert(3);
    ust.insert(7);
    cout << "unordered_set size = " << ust.size() << "\n";

    string s;
    cout << "Enter a word: ";
    cin >> s;
    map<char, int> freq;
    for (char c : s) freq[c]++;

    cout << "Frequencies: ";
    for (auto &p : freq) cout << p.first << ":" << p.second << " ";
    cout << "\n";

    unordered_map<string, int> mp;
    mp["apple"] = 2;
    mp["banana"] = 5;
    cout << "banana count = " << mp["banana"] << "\n";

    return 0;
}
