class Solution
{
    public:
        int uniqueMorseRepresentations(vector<string> &words)
        {
            vector<string> morseCode = { ".-",
                "-...",
                "-.-.",
                "-..",
                ".",
                "..-.",
                "--.",
                "....",
                "..",
                ".---",
                "-.-",
                ".-..",
                "--",
                "-.",
                "---",
                ".--.",
                "--.-",
                ".-.",
                "...",
                "-",
                "..-",
                "...-",
                ".--",
                "-..-",
                "-.--",
                "--.." };

            unordered_set<string> uset;
            for (string &str: words)
            {
                string encoded = "";
                for (char &ch: str)
                {
                    encoded += morseCode[ch - 'a'];
                }
                uset.insert(encoded);
            }

            return uset.size();
        }
};