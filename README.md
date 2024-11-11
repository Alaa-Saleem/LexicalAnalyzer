Step 1: Store Pascal Keywords in a List or Array
We stored the list of Pascal keywords in an array, ensuring that all keywords are in uppercase for easy comparison during token identification.

Step 2: Declare a Token Class
A Token class was defined to store each token's name, type, and line number. This helps in organizing and processing the extracted tokens.

Step 3: Open and Read the Pascal File
The Pascal file (p.txt) was opened and read line by line using BufferedReader. This allows us to process each line in the file sequentially.

Step 4: Read a Line (as String) from the File
For each line, we read the string and pass it to the lexical analyzer for further processing.

Step 5: Handle Empty Lines
If a line is empty (i.e., contains only spaces), we simply skip it and move to the next line.

Step 6: Ignore Leading Blanks
Leading whitespace at the beginning of each line is ignored by trimming the line using trim() before processing.

Step 7: Convert Line to Uppercase
Since Pascal is case-insensitive, we convert each line to uppercase using toUpperCase() to ensure uniformity when identifying keywords and other tokens.

Step 8: Extract and Classify Tokens
The line is split into tokens (words) using the split() function. Each token is then classified into one of three categories:
Keyword: If the token matches a keyword from the list.
Numeric Constant: If the token is a number.
Identifier: If the token matches the naming pattern of identifiers in Pascal (letters or underscores followed by letters, numbers, or underscores).

Step 9: Handle Special Characters
Special characters such as semicolons (;), colons (:), and assignment operators (:=) are also treated as tokens

Final Output:
After processing all the tokens, we store them and print them to verify the correct classification of keywords, identifiers, numeric constants, and special characters.
