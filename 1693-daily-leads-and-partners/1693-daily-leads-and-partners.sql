SELECT date_id,
       make_name,
       Count(DISTINCT lead_id) AS unique_leads,
       Count(DISTINCT partner_id) AS unique_partners
FROM   DailySales
GROUP  BY date_id,
          make_name; 