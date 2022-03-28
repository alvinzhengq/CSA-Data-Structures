---
title: Notes & Plans
icon: fas fa-info-circle
order: 2
---

### College Board AP Exam Study Plan

### Weekly Tech Talk Notes

<ul>
  {% for post in site.posts %}
    <li>
      <p><a href="{{ post.url | prepend: site.baseurl }}">{{ post.title }}</a></p>
    </li>
  {% endfor %}
</ul>