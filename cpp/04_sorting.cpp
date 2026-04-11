// Sorting and custom comparator
// Build: g++ -std=c++17 04_sorting.cpp -o sorting

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool bySecondThenFirst(const pair<int,int> &a, const pair<int,int> &b) {
    if (a.second != b.second) return a.second < b.second;
    return a.first < b.first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> nums = {5, 1, 4, 2, 3};
    sort(nums.begin(), nums.end());

    cout << "Sorted: ";
    for (int x : nums) cout << x << " ";
    cout << "\n";

    vector<pair<int,int>> pairs = {{3, 2}, {1, 2}, {2, 1}};
    sort(pairs.begin(), pairs.end(), bySecondThenFirst);

    cout << "Pairs sorted by (second, first): ";
    for (auto &p : pairs) cout << "(" << p.first << "," << p.second << ") ";
    cout << "\n";

    return 0;
}
