class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        tracked = set()
        counts: dict[str, int] = dict()

        for item in nums:
            if item not in tracked:
                counts[item] = 0
                tracked.add(item)

            counts[item] += 1

        return [item for item in dict(sorted(counts.items(), key=lambda item: item[1], reverse=True))][:k]

        