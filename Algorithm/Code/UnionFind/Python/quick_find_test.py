from _pytest.fixtures import fixture
import re

from quick_find import QuickFind


class TestQuickFind(object):

    @fixture
    def quick_find_tinny(self):
        return QuickFind(10)

    @fixture
    def tinny_file(self):
        def gen():
            with open("tinyUF.txt", 'r') as f:
                for line in f.readlines():
                    yield line
        return gen()

    def test_tinny(self, tinny_file, quick_find_tinny):
        try:
            while True:
                p, q, *rest = re.split(r"\s+", next(tinny_file))
                p, q = int(p), int(q)
                quick_find_tinny.uf(p, q)
                assert quick_find_tinny.is_connect(p, q), True
                print(quick_find_tinny.ids)
        except StopIteration:
            pass

