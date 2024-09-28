package twopointers.n445AssignCookies


class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()

        var gIdx = 0
        var sIdx = 0

        var contentCount = 0

        while(gIdx < g.size && sIdx < s.size){

            var greed = g[gIdx]

            while(sIdx < s.size && greed > s[sIdx]){
                sIdx++
            }
            if(sIdx >= s.size){
                break
            }

            contentCount++
            gIdx++
            sIdx++
        }

        return contentCount;
    }
}