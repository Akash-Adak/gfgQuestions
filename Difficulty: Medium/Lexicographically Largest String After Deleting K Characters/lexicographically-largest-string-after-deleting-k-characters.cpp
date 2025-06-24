class Solution {
  public:
    string maxSubseq(string& s, int k) {
        int n = s.size();
        int keep = n - k;
        string result;

        for (char c : s) {
            // While we can pop and the last character is smaller than current
            while (!result.empty() && k > 0 && result.back() < c) {
                result.pop_back();
                k--;
            }
            result.push_back(c);
        }

        // Return only the first 'keep' characters
        return result.substr(0, keep);
    }
};
