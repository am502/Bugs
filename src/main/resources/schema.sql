DROP TABLE IF EXISTS procedures CASCADE;
DROP TABLE IF EXISTS lots CASCADE;
DROP TABLE IF EXISTS positions CASCADE;

CREATE TABLE IF NOT EXISTS procedures(
  id INT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS lots(
  id INT PRIMARY KEY,
  procedure_id INT REFERENCES procedures(id) ON DELETE CASCADE,
  cost INT
);

CREATE TABLE IF NOT EXISTS positions(
  id INT PRIMARY KEY,
  lot_id INT REFERENCES lots(id) ON DELETE CASCADE,
  count INT
);

INSERT INTO procedures VALUES (1, 'Procedure 1'), (2, 'Procedure 2');

INSERT INTO lots VALUES (1, 1, 335), (2, 1, 242);

INSERT INTO positions VALUES (1, 1, 3), (2, 1, 5), (3, 1, 1);
INSERT INTO positions VALUES (4, 2, 2), (5, 2, 4);

INSERT INTO lots VALUES (3, 2, 100);

INSERT INTO positions VALUES (6, 3, 5);

SELECT pr.name, COALESCE(SUM(s.cost), 0) AS lots_cost, COALESCE(SUM(s.c), 0) AS positions_count FROM (
  SELECT pr.id, l.cost, SUM(po.count) AS c FROM procedures pr
  LEFT JOIN lots l ON pr.id = l.procedure_id
  LEFT JOIN positions po ON l.id = po.lot_id
  GROUP BY pr.id, l.id
) s INNER JOIN procedures pr ON s.id = pr.id GROUP BY pr.id;