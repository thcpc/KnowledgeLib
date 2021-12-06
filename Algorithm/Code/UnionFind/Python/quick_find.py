class QuickFind(object):
    def __init__(self, n):
        self.ids = list(range(0, n))

    def find(self, p: int):
        return self.ids[p]

    def uf(self, p: int, q: int):
        pid = self.find(p)
        qid = self.find(q)
        if pid == qid:
            return
        else:
            for i, iD in enumerate(self.ids):
                if iD == pid and iD != qid:
                    self.ids[i] = qid

    def is_connect(self, p: int, q: int):
        return self.find(p) == self.find(q)
