using System;


namespace Loggboken_v2
{
    class Bok
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public DateTime Date = DateTime.Now;
        public int ISBN { get; set; }
        public string Text { get; set; }
    }
}
