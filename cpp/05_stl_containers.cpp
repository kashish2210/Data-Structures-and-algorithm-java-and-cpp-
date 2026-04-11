// Stack, queue, deque, and priority_queue
// Build: g++ -std=c++17 05_stl_containers.cpp -o stl_containers

#include <iostream>
#include <stack>
#include <queue>
#include <deque>
using namespace std;

bool isBalanced(const string &s) {
    stack<char> st;
    for (char c : s) {
        if (c == '(') st.push(c);
        else if (c == ')') {
            if (st.empty()) return false;
            st.pop();
        }
    }
    return st.empty();
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    queue<int> q;
    q.push(1); q.push(2); q.push(3);
    cout << "Queue front: " << q.front() << "\n";

    deque<int> dq;
    dq.push_front(10);
    dq.push_back(20);
    cout << "Deque front/back: " << dq.front() << " " << dq.back() << "\n";

    priority_queue<int> pq;
    pq.push(5); pq.push(1); pq.push(9);
    cout << "Max-heap top: " << pq.top() << "\n";

    cout << "Enter parentheses string: ";
    string s;
    cin >> s;
    cout << (isBalanced(s) ? "Balanced" : "Not balanced") << "\n";

    return 0;
}
