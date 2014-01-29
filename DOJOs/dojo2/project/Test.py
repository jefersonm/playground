import unittest
import Company as c

class CompanyTest(unittest.TestCase):

    def test_name(self):
        comp = [c.Company()]
        self.assertEqual(c.Company().getName(), "fuel")
    
        
if __name__ == '__main__':
    unittest.main()