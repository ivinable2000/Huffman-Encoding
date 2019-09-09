# Huffman-Encoding
Using the main file, Huffman.java, a text file can be compressed and a frequency file made to be used for decompression

For example, Huffman -c text.fre text.txt text.cmp will compress text.txt into text.cmp and also generate the frequency file text.fre used for decompression

Then, Huffman -d text.fre text.dcp text.cmp decompresses text.cmp into text.dcp using the frequency file text.fre

text.txt and text.dcp are identical
